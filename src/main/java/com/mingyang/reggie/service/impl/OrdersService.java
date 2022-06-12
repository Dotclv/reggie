package com.mingyang.reggie.service.impl;

import java.util.List;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface OrdersService extends IService<Orders>{


    int updateBatch(List<Orders> list);

    int batchInsert(List<Orders> list);

    Result pages(Integer page, Integer pageSize, Integer number, String beginTime, String endTime);
}
