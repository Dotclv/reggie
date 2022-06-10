package com.mingyang.reggie.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.EmployeeMapper;
import com.mingyang.reggie.entity.Employee;
import com.mingyang.reggie.service.impl.EmployeeService;
/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService{

    @Override
    public int updateBatch(List<Employee> list) {
        return baseMapper.updateBatch(list);
    }
    @Override
    public int batchInsert(List<Employee> list) {
        return baseMapper.batchInsert(list);
    }
}
