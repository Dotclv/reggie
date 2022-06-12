package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.entity.DishFlavor;
import com.mingyang.reggie.entity.dto.FlavorsDTO;
import com.mingyang.reggie.entity.vo.DishPageVO;
import com.mingyang.reggie.entity.vo.DishVO;
import com.mingyang.reggie.service.impl.DishFlavorService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import java.util.stream.Collectors;

import com.mingyang.reggie.mapper.DishMapper;
import com.mingyang.reggie.entity.Dish;
import com.mingyang.reggie.service.impl.DishService;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Slf4j
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService{

    @Resource
    private DishFlavorService flavorService;

    @Override
    public int updateBatch(List<Dish> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Dish> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Result pages(Integer page, Integer pageSize, String name) {
        Page<Dish> dishPage = new Page<>(page, pageSize);
        QueryWrapper<Dish> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),"dish.name", name);
        IPage<DishPageVO> voPage = baseMapper.page(dishPage, queryWrapper);
        return Result.success(voPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(DishVO dishVO) {
        Dish dish = DishVO.convertToDishVO(dishVO);
        boolean save = this.save(dish);
        if (!save) {
            log.error("添加菜品失败");
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        if(dishVO.getFlavors().size() > 0 && dishVO.getFlavors() != null){
            List<DishFlavor> flavors = dishVO.getFlavors().stream().map(flavor -> {
                DishFlavor dishFlavor = new DishFlavor();
                dishFlavor.setDishId(dish.getId());
                dishFlavor.setName(flavor.getName());
                dishFlavor.setValue(flavor.getValue());
                return dishFlavor;
            }).collect(Collectors.toList());

            boolean b = flavorService.saveBatch(flavors);
            if (!b) {
                log.error("添加菜品属性失败");
                return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
            }
        }
        return Result.success(dish.getId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(DishVO dishVO) {
        Dish dish = DishVO.convertToDishVO(dishVO);
        boolean b = this.updateById(dish);
        if (!b) {
            log.error("更新菜品失败");
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        if(dishVO.getFlavors().size() > 0 && dishVO.getFlavors() != null){
            flavorService.remove(new QueryWrapper<DishFlavor>().eq("dish_id", dish.getId()));
            List<DishFlavor> flavors = dishVO.getFlavors().stream().map(flavor -> {
                DishFlavor dishFlavor = new DishFlavor();
                dishFlavor.setDishId(dish.getId());
                dishFlavor.setName(flavor.getName());
                dishFlavor.setValue(flavor.getValue());
                return dishFlavor;
            }).collect(Collectors.toList());

            boolean b1 = flavorService.saveBatch(flavors);
            if (!b1) {
                log.error("添加菜品属性失败");
                return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
            }
        }

        return Result.success(dish.getId());
    }

    @Override
    public Result getDish(Long id) {
        Dish dish = baseMapper.selectById(id);
        if (dish == null) {
            log.error("菜品不存在");
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        List<DishFlavor> flavorList = flavorService.list(new QueryWrapper<DishFlavor>().eq("dish_id", id));
        List<FlavorsDTO> flavors = flavorList.stream().map(flavor -> {
            FlavorsDTO flavorsDTO = new FlavorsDTO();
            flavorsDTO.setName(flavor.getName());
            flavorsDTO.setValue(flavor.getValue());
            return flavorsDTO;
        }).collect(Collectors.toList());
        DishVO dishVO = DishVO.convertToDishVO(dish);
        dishVO.setFlavors(flavors);
        return Result.success(dishVO);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result delete(String ids) {
        String[] split = ids.split(",");
        List<String> list = Arrays.asList(split);
        List<Long> longs = list.stream().map(l -> Long.valueOf(l)).collect(Collectors.toList());
        boolean b = this.removeByIds(longs);
        if (!b) {
            log.error("删除菜品失败");
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        boolean b1 = flavorService.remove(new QueryWrapper<DishFlavor>().in("dish_id", longs));
        if(!b1){
            log.error("删除菜品属性失败");
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        return Result.success();
    }

    @Override
    public Result updateStatus(String ids, Integer type) {
        String[] split = ids.split(",");
        List<String> list = Arrays.asList(split);
        List<Long> longs = list.stream().map(l -> Long.valueOf(l)).collect(Collectors.toList());
        UpdateWrapper<Dish> wrapper = new UpdateWrapper<>();
        wrapper.lambda().in(Dish::getId, longs)
                        .set(Dish::getStatus, type);
        return this.update(wrapper)?Result.success():Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
    }
}
