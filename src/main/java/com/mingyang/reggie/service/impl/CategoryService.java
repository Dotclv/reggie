package com.mingyang.reggie.service.impl;

import java.util.List;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingyang.reggie.entity.vo.CategoryVO;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface CategoryService extends IService<Category>{


    int updateBatch(List<Category> list);

    int batchInsert(List<Category> list);
   /**
    *
    * @param page 页码
    * @param pageSize 每页数量
    * @return 分页列表
    */
    Result pages(Integer page, Integer pageSize);

    /**
     * 添加分类
     * @param category
     * @return
     */
    Result add(CategoryVO category);

    Result update(CategoryVO category);

    Result getCategory(String id);

    Result delete(Long id);

    Result getListByType(String type);
}
