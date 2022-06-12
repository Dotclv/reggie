package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.vo.OrdersPageVO;
import org.apache.commons.lang3.StringUtils;
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

    @Override
    public Result pages(Integer page, Integer pageSize, Integer number, String beginTime, String endTime) {
        Page<Orders> ordersPage = new Page<>(page, pageSize);
        QueryWrapper<Object> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(number != null,"orders.number", number);
        queryWrapper.between(StringUtils.isNotEmpty(beginTime) && StringUtils.isNotEmpty(endTime),
                              "orders.order_time", beginTime, endTime);
        IPage<OrdersPageVO> iPage = baseMapper.page(ordersPage, queryWrapper);
        return Result.success(iPage);
    }
}
