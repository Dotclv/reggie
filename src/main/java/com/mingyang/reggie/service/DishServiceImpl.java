package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.vo.DishPageVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.DishMapper;
import com.mingyang.reggie.entity.Dish;
import com.mingyang.reggie.service.impl.DishService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class DishServiceImpl extends ServiceImpl<DishMapper, Dish> implements DishService{

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
}
