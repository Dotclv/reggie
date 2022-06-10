package com.mingyang.reggie.service.impl;

import java.util.List;
import com.mingyang.reggie.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
    /**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
public interface EmployeeService extends IService<Employee>{


    int updateBatch(List<Employee> list);

    int batchInsert(List<Employee> list);

}
