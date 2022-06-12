package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.vo.SetMealVO;
import com.mingyang.reggie.service.impl.SetmealService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 23:03
 * @version: 1.0
 */
@RestController
@RequestMapping("/setmeal")
public class SetMealController {

    @Resource
    private SetmealService setMealService;

    @RequestMapping("/page")
    public Result page(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize,
                       @RequestParam(value = "name",required = false)String name) {
        return setMealService.pages(page, pageSize,name);
    }

    /**
     * 新增套餐
     * @param setMealVO
     * @return Result
     */
    @RequestMapping
    public Result add(@RequestBody SetMealVO setMealVO) {
        return setMealService.add(setMealVO);
    }

    /**
     * 更新套餐
     * @param setMealVO
     * @return Result
     */
    @PutMapping
    public Result update(@RequestBody SetMealVO setMealVO) {
        return setMealService.update(setMealVO);
    }

    /**
     * 根据id查询套餐
     * @param id
     * @return Result
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id")String id) {
        return setMealService.getSetMeal(id);
    }

    /**
     * 批量删除套餐
     * @param ids
     * @return Result
     */
    @DeleteMapping
    public Result deleteBatch(@RequestParam("ids")String ids) {
        return setMealService.delete(ids);
    }

    /**
     * 更新套餐状态
     * @param ids
     * @param type
     * @return
     */
    @PostMapping("/status/{type}")
    public Result updateStatus(@RequestParam("ids") String ids, @PathVariable("type") Integer type) {
        return setMealService.updateStatus(ids,type);
    }
}
