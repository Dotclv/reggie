package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Employee;
import com.mingyang.reggie.service.impl.EmployeeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 23:01
 * @version: 1.0
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @PostMapping("/login")
    public Result login(HttpServletRequest request, @RequestBody Employee employee) {
        return employeeService.login(request, employee);
    }
}
