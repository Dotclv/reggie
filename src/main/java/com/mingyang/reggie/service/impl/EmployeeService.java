package com.mingyang.reggie.service.impl;

import java.util.List;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Employee;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mingyang.reggie.entity.dto.EmployeeDTO;
import com.mingyang.reggie.entity.dto.EmployeeLoginDTO;

import javax.servlet.http.HttpServletRequest;

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

    /**
     * 登录
     * @param request  HttpServletRequest
     * @param employee Employee
     * @return Result<Employee>
     */
    Result login(HttpServletRequest request, EmployeeLoginDTO employee);

    /**
     * 登出
     * @param request   HttpServletRequest
     * @return Result<Employee>
     */
    Result logout(HttpServletRequest request);

    /**
     * 分页查询
     * @param page
     * @param size
     * @param name
     * @return
     */
    Result page(Integer page, Integer size, String name);

    /**
     * 新增员工信息
     * @param employee EmployeeDTO
     * @return Result<Employee>
     */
    Result add(EmployeeDTO employee, HttpServletRequest request);

    /**
     * 更新员工信息
     * @param employee EmployeeDTO
     * @return Result<Employee>
     */
    Result update(EmployeeDTO employee);

    /**
     * 根据id查询员工信息
     * @param id
     * @return
     */
    Result getEmployee(String id);
}
