package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.vo.DishVO;
import com.mingyang.reggie.service.impl.DishService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    /**
     * 添加菜品
     * @param dishVO
     * @return Result
     */
    @PostMapping
    public Result add(@RequestBody DishVO dishVO) {
        return dishService.add(dishVO);
    }

    /**
     * 更新菜品
     * @param dishVO
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody DishVO dishVO) {
        return dishService.update(dishVO);
    }

    /**
     * 根据id查询菜品
     * @param id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable("id")Long id) {
        return dishService.getDish(id);
    }

    /**
     * 批量删除菜品
     * @param ids
     * @return Result
     */
    @DeleteMapping
    public Result delete(@RequestParam("ids") String ids) {
        return dishService.delete(ids);
    }
    /**
     * 批量更新菜品
     * @param ids
     * @return Result
     */
    @PostMapping("/status/{type}")
    public Result updateStatus(@RequestParam("ids") String ids, @PathVariable("type") Integer type) {
        return dishService.updateStatus(ids,type);
    }

    /**
     * 根据菜品分类id查询菜品
     * @param categoryId
     * @return Result
     */
    @GetMapping("/list")
    public Result list(@RequestParam("categoryId") Long categoryId) {
        return dishService.list(categoryId);
    }

}
