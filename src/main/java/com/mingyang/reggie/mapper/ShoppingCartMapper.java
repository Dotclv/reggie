package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingyang.reggie.entity.ShoppingCart;
import java.util.List;

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
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {
    int updateBatch(List<ShoppingCart> list);

    int batchInsert(@Param("list") List<ShoppingCart> list);
}