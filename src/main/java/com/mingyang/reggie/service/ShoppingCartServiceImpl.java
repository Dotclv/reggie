package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.ShoppingCartMapper;
import com.mingyang.reggie.entity.ShoppingCart;
import com.mingyang.reggie.service.impl.ShoppingCartService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class ShoppingCartServiceImpl extends ServiceImpl<ShoppingCartMapper, ShoppingCart> implements ShoppingCartService{

    @Override
    public int updateBatch(List<ShoppingCart> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<ShoppingCart> list) {
        return baseMapper.batchInsert(list);
    }
}
