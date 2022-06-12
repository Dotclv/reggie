package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.entity.Dish;
import java.util.List;

import com.mingyang.reggie.entity.vo.DishPageVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Mapper
public interface DishMapper extends BaseMapper<Dish> {
    int updateBatch(List<Dish> list);

    int batchInsert(@Param("list") List<Dish> list);

    IPage<DishPageVO> page(Page<Dish> dishPage, @Param(Constants.WRAPPER) QueryWrapper<Dish> queryWrapper);

}