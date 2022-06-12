package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.service.impl.OrdersService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author: ymy
 * @program: reggie
 * @description: 订单
 * @date: 2022/6/12 21:56
 * @version: 1.0
 */
@RestController
@RequestMapping("/order")
public class OrdersController {

    @Resource
    private OrdersService ordersService;

    @ApiOperation(value = "根据订单号查询订单")
    @GetMapping("/page")
    public Result page(@RequestParam("page") Integer page, @RequestParam("pageSize") Integer pageSize,
                       @RequestParam(value = "number",required = false) Integer number,
                       @RequestParam(value = "beginTime",required = false) String beginTime,
                       @RequestParam(value = "endTime",required = false) String endTime) {
        return ordersService.pages(page, pageSize, number, beginTime, endTime);
    }
}
