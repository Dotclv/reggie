package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.enums.CategoryEnum;
import com.mingyang.reggie.common.exception.BuzException;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.entity.Dish;
import com.mingyang.reggie.entity.Setmeal;
import com.mingyang.reggie.entity.SetmealDish;
import com.mingyang.reggie.entity.vo.CategoryPageVO;
import com.mingyang.reggie.entity.vo.CategoryVO;
import com.mingyang.reggie.service.impl.DishService;
import com.mingyang.reggie.service.impl.SetmealService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.CategoryMapper;
import com.mingyang.reggie.entity.Category;
import com.mingyang.reggie.service.impl.CategoryService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService{

    @Resource
    private DishService dishService;

    @Resource
    private SetmealService setmealService;

    @Override
    public int updateBatch(List<Category> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Category> list) {
        return baseMapper.batchInsert(list);
    }

    @Override
    public Result pages(Integer page, Integer pageSize) {
        Page<Category> categoryPage = new Page<>(page, pageSize);
        QueryWrapper<Category> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(Category::getIsDeleted, EntityConstant.IS_NOT_DELETED)
                    .orderByDesc(Category::getSort);
        IPage<CategoryPageVO> voPage = baseMapper.page(categoryPage, queryWrapper);
        return Result.success(voPage);
    }

    @Override
    public Result add(CategoryVO category) {
        Category convert = CategoryVO.convertToCategoryVO(category);
        return this.save(convert) ? Result.success() : Result.failure(ResultCode.PARAM_ERROR);
    }

    @Override
    public Result update(CategoryVO category) {
        Category convert = CategoryVO.convertToCategoryVO(category);
        return this.updateById(convert) ? Result.success() : Result.failure(ResultCode.PARAM_ERROR);
    }

    @Override
    public Result getCategory(String id) {
        return Result.success(this.getById(id));
    }

    @Override
    public Result delete(Long id) {
        Category category = this.getById(id);
        if(category.getType().equals(CategoryEnum.FOOD_CATEGORY.getCode())) {
            QueryWrapper<Dish> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(Dish::getCategoryId, id);
            long count = dishService.count(wrapper);
            if(count > 0) {
                throw new BuzException(ResultCode.CATEGORY_HAS_DISH);
            }
        }
        if(category.getType().equals(CategoryEnum.PACKAGE_CATEGORY.getCode())) {
            QueryWrapper<Setmeal> wrapper = new QueryWrapper<>();
            wrapper.lambda().eq(Setmeal::getCategoryId, id);
            long count = setmealService.count(wrapper);
            if(count > 0) {
                throw new BuzException(ResultCode.CATEGORY_HAS_SETMEAL);
            }
        }
        return this.removeById(id) ? Result.success() : Result.failure(ResultCode.PARAM_ERROR);
    }

    @Override
    public Result getListByType(String type)
    {
        QueryWrapper<Category> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Category::getIsDeleted, EntityConstant.IS_NOT_DELETED)
                .eq(StringUtils.isNotEmpty(type),Category::getType, type)
                .orderByDesc(Category::getUpdateTime);
        return Result.success(this.list(wrapper));
    }

}
