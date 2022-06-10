package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingyang.reggie.mapper.OrderDetailMapper;
import java.util.List;
import com.mingyang.reggie.entity.OrderDetail;
import com.mingyang.reggie.service.impl.OrderDetailService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class OrderDetailServiceImpl extends ServiceImpl<OrderDetailMapper, OrderDetail> implements OrderDetailService{

    @Override
    public int updateBatch(List<OrderDetail> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<OrderDetail> list) {
        return baseMapper.batchInsert(list);
    }
}
