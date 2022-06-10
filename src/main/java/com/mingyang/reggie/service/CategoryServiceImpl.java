package com.mingyang.reggie.service;

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

    @Override
    public int updateBatch(List<Category> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Category> list) {
        return baseMapper.batchInsert(list);
    }
}
