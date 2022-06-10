package com.mingyang.reggie.service.impl;

import java.util.List;
import com.mingyang.reggie.entity.Dish;
import com.baomidou.mybatisplus.extension.service.IService;
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

}
