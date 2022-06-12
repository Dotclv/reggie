package com.mingyang.reggie.service.impl;

import java.util.List;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingyang.reggie.entity.vo.DishVO;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface DishService extends IService<Dish>{


    int updateBatch(List<Dish> list);

    int batchInsert(List<Dish> list);

    Result pages(Integer page, Integer pageSize, String name);

    Result add(DishVO dishVO);

    Result update(DishVO dishVO);

    Result getDish(Long id);

    Result delete(List<Long> ids);

    Result updateStatus(String ids, Integer type);

    Result list(Long categoryId);

}
