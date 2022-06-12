package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.vo.CategoryVO;
import com.mingyang.reggie.service.impl.CategoryService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 22:59
 * @version: 1.0
 */
@Api(value = "分类接口", tags = "分类接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Resource
    private CategoryService categoryService;

    /**
     * 获取分页列表
     */
    @GetMapping("/page")
    public Result page(@RequestParam("page")Integer page, @RequestParam("pageSize")Integer pageSize) {
        return categoryService.pages(page, pageSize);
    }

    /**
     * 分类添加
     * @param category
     * @return 添加结果
     */
    @PostMapping
    public Result add(@RequestBody CategoryVO category) {
        return categoryService.add(category);
    }

    /**
     * 分类修改
     * @param category
     * @return 修改结果
     */
    @PutMapping()
    public Result update(@RequestBody CategoryVO category) {
        return categoryService.update(category);
    }

    /**
     * 查询分类
     * @param id
     * @return 分类
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable("id") String id) {
        return categoryService.getCategory(id);
    }

    /**
     * 删除分类
     * @param ids
     * @return 删除结果
     */
    @DeleteMapping()
    public Result delete(@RequestParam("ids") Long ids) {
        return categoryService.delete(ids);
    }

    /**
     * 根据类型查询分类
     * @param type
     * @return 分类
     */
    @GetMapping("/list")
    public Result getByType(@RequestParam("type") String type) {
        return categoryService.getListByType(type);
    }
}
