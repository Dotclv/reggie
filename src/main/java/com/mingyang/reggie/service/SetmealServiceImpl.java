package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.entity.Setmeal;
import com.mingyang.reggie.mapper.SetmealMapper;
import com.mingyang.reggie.service.impl.SetmealService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService{

    @Override
    public int updateBatch(List<Setmeal> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Setmeal> list) {
        return baseMapper.batchInsert(list);
    }
}
