package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.service.impl.DishService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 23:00
 * @version: 1.0
 */
@Api(value = "菜品管理", tags = "菜品管理")
@RestController
@RequestMapping("/dish")
public class DishController {

    @Resource
    private DishService dishService;

    @GetMapping("/page")
    public Result page(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize,
                       @RequestParam(value = "name",required = false)String name) {
        return dishService.pages(page, pageSize,name);
    }
}
