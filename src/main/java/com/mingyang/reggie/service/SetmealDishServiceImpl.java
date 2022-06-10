package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingyang.reggie.mapper.SetmealDishMapper;
import java.util.List;
import com.mingyang.reggie.entity.SetmealDish;
import com.mingyang.reggie.service.impl.SetmealDishService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class SetmealDishServiceImpl extends ServiceImpl<SetmealDishMapper, SetmealDish> implements SetmealDishService{

    @Override
    public int updateBatch(List<SetmealDish> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<SetmealDish> list) {
        return baseMapper.batchInsert(list);
    }
}
