package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.entity.Category;
import java.util.List;

import com.mingyang.reggie.entity.vo.CategoryPageVO;
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
public interface CategoryMapper extends BaseMapper<Category> {
    int updateBatch(List<Category> list);

    int batchInsert(@Param("list") List<Category> list);

    /**
     * 获取分页列表
     * @param categoryPage  分页对象
     * @param queryWrapper  查询对象
     * @return 分页对象
     */
    IPage<CategoryPageVO> page(Page<Category> categoryPage, @Param(Constants.WRAPPER) QueryWrapper<Category> queryWrapper);
}