package com.mingyang.reggie.service.impl;

import java.util.List;
import com.mingyang.reggie.entity.Category;
import com.baomidou.mybatisplus.extension.service.IService;
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

}
