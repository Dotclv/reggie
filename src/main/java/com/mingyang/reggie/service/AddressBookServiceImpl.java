package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mingyang.reggie.mapper.AddressBookMapper;
import java.util.List;
import com.mingyang.reggie.entity.AddressBook;
import com.mingyang.reggie.service.impl.AddressBookService;

/**
 * @author: ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {

    @Override
    public int updateBatch(List<AddressBook> list) {
        return baseMapper.updateBatch(list);
    }

    @Override
    public int batchInsert(List<AddressBook> list) {
        return baseMapper.batchInsert(list);
    }
}

