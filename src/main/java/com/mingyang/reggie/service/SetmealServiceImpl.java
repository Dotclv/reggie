package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.common.collect.Lists;
import com.mingyang.reggie.common.exception.BuzException;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.entity.SetmealDish;
import com.mingyang.reggie.entity.dto.SetmealDishesDTO;
import com.mingyang.reggie.entity.vo.SetMealPageVO;
import com.mingyang.reggie.entity.vo.SetMealVO;
import com.mingyang.reggie.service.impl.SetmealDishService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import java.util.stream.Collectors;

import com.mingyang.reggie.entity.Setmeal;
import com.mingyang.reggie.mapper.SetmealMapper;
import com.mingyang.reggie.service.impl.SetmealService;
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
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService{

    @Resource
    private SetmealDishService setmealDishService;

    @Override
    public int updateBatch(List<Setmeal> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Setmeal> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Result pages(Integer page, Integer pageSize, String name) {
        Page<Setmeal> setmealPage = new Page<>(page, pageSize);
        QueryWrapper<Setmeal> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotEmpty(name),"setmeal.name", name);
        IPage<SetMealPageVO> voPage = baseMapper.page(setmealPage, queryWrapper);
        return Result.success(voPage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result add(SetMealVO setMealVO) {
        Setmeal setmeal = SetMealVO.convertToSetmeal(setMealVO);
        boolean save = this.save(setmeal);
        if (!save) {
            log.error("【新增套餐】插入套餐数据失败，setmeal={}", setmeal);
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        if(setMealVO.getSetmealDishes() != null && setMealVO.getSetmealDishes().size() > 0){
            List<SetmealDish> setmealDishes = setMealVO.getSetmealDishes().stream().map(l -> {
                SetmealDish setmealDish = new SetmealDish();
                setmealDish.setDishId(l.getDishId());
                setmealDish.setSetmealId(setmeal.getId().toString());
                setmealDish.setPrice(l.getPrice());
                setmealDish.setCopies(l.getCopies());
                setmealDish.setName(l.getName());
                return setmealDish;
            }).collect(Collectors.toList());
            boolean batch = setmealDishService.saveBatch(setmealDishes);
            if(!batch){
                log.error("套餐菜品新增失败，setmealDishes={}", setmealDishes);
                return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
            }
        }
        return Result.success();
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result update(SetMealVO setMealVO) {
        Setmeal setmeal = SetMealVO.convertToSetmeal(setMealVO);
        boolean b = this.updateById(setmeal);
        if (!b) {
            log.error("【修改套餐】更新套餐数据失败，setmeal={}", setmeal);
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        if(setMealVO.getSetmealDishes() != null && setMealVO.getSetmealDishes().size() > 0){
            QueryWrapper<SetmealDish> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(SetmealDish::getSetmealId, setmeal.getId());
            boolean remove = setmealDishService.remove(wrapper);
            if (!remove) {
                log.error("套餐菜品删除失败，setmealDishes={}", setmeal.getId());
            }
            List<SetmealDish> setmealDishes = setMealVO.getSetmealDishes().stream().map(l -> {
                SetmealDish setmealDish = new SetmealDish();
                setmealDish.setDishId(l.getDishId());
                setmealDish.setSetmealId(setmeal.getId().toString());
                setmealDish.setPrice(l.getPrice());
                setmealDish.setCopies(l.getCopies());
                setmealDish.setName(l.getName());
                return setmealDish;
            }).collect(Collectors.toList());
            boolean batch = setmealDishService.saveBatch(setmealDishes);
            if(!batch){
                log.error("套餐菜品新增失败，setmealDishes={}", setmealDishes);
                return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
            }
        }
        return Result.success();
    }

    @Override
    public Result getSetMeal(String id) {
        SetMealVO setMealVO = SetMealVO.convertToSetMealVO(this.getById(id));
        List<SetmealDish> setmealDishes = setmealDishService.list(new QueryWrapper<SetmealDish>().lambda().eq(SetmealDish::getSetmealId, id));
        List<SetmealDishesDTO> setmealDishesList = Lists.newArrayList();
        if(setmealDishes != null && setmealDishes.size() > 0){
            setmealDishesList = setmealDishes.stream().map(s -> {
                SetmealDishesDTO dto = new SetmealDishesDTO();
                dto.setPrice(s.getPrice());
                dto.setCopies(s.getCopies());
                dto.setName(s.getName());
                dto.setDishId(s.getDishId());
                return dto;
            }).collect(Collectors.toList());
        }
        setMealVO.setSetmealDishes(setmealDishesList);
        return Result.success(setMealVO);
    }

    @Override
    public Result delete(List<Long> ids) {
        if(this.count(new QueryWrapper<Setmeal>().lambda().in(Setmeal::getId, ids).eq(Setmeal::getStatus, 1)) > 0) {
            throw new BuzException(ResultCode.CATEGORY_HAS_SETMEAL);
        }
        boolean b = this.removeByIds(ids);
        if (!b) {
            log.error("【删除套餐】删除套餐数据失败，ids={}", ids);
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        QueryWrapper<SetmealDish> wrapper = new QueryWrapper<>();
        wrapper.lambda().in(SetmealDish::getSetmealId, ids);
        boolean remove = setmealDishService.remove(wrapper);
        if (!remove) {
            log.error("套餐菜品删除失败，setmealDishes={}", ids);
            return Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
        }
        return Result.success();
    }

    @Override
    public Result updateStatus(List<Long> ids, Integer type) {
        UpdateWrapper<Setmeal> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().in(Setmeal::getId, ids)
                .set(Setmeal::getStatus, type);
        return this.update(updateWrapper) ? Result.success() : Result.failure(ResultCode.INTERFACE_RETURN_ERROR);
    }
}
