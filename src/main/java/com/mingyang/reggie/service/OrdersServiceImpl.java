package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.OrdersMapper;
import com.mingyang.reggie.entity.Orders;
import com.mingyang.reggie.service.impl.OrdersService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService{

    @Override
    public int updateBatch(List<Orders> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Orders> list) {
        return baseMapper.batchInsert(list);
    }
}
