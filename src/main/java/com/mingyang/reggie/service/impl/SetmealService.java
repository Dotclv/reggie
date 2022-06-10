package com.mingyang.reggie.service.impl;

import java.util.List;
import com.mingyang.reggie.entity.Setmeal;
import com.baomidou.mybatisplus.extension.service.IService;
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

}
