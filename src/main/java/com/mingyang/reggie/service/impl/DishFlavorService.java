package com.mingyang.reggie.service.impl;

import java.util.List;
import com.mingyang.reggie.entity.DishFlavor;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface DishFlavorService extends IService<DishFlavor>{


    int updateBatch(List<DishFlavor> list);

    int batchInsert(List<DishFlavor> list);

}
