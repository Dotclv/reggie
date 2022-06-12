package com.mingyang.reggie.service.impl;

import java.util.List;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingyang.reggie.entity.vo.SetMealVO;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface SetmealService extends IService<Setmeal>{


    int updateBatch(List<Setmeal> list);

    int batchInsert(List<Setmeal> list);

    Result pages(Integer page, Integer pageSize, String name);

    Result add(SetMealVO setMealVO);

    Result update(SetMealVO setMealVO);

    Result getSetMeal(String id);

    Result delete(List<Long> ids);

    Result updateStatus(List<Long> ids, Integer type);
}
