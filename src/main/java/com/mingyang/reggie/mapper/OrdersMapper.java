package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.entity.Orders;
import java.util.List;

import com.mingyang.reggie.entity.vo.OrdersPageVO;
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
public interface OrdersMapper extends BaseMapper<Orders> {
    int updateBatch(List<Orders> list);

    int batchInsert(@Param("list") List<Orders> list);

    IPage<OrdersPageVO> page(Page<Orders> ordersPage,@Param(Constants.WRAPPER) QueryWrapper<Object> queryWrapper);
}