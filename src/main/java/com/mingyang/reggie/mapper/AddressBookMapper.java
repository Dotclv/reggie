package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mingyang.reggie.entity.AddressBook;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author: ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:53
 * @version: 1.0
 */
@Mapper
public interface AddressBookMapper extends BaseMapper<AddressBook> {
    int updateBatch(List<AddressBook> list);

    int batchInsert(@Param("list") List<AddressBook> list);
}