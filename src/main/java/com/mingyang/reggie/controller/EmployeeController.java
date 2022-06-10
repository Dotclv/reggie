package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Employee;
import com.mingyang.reggie.entity.dto.EnployeeDTO;
import com.mingyang.reggie.service.impl.EmployeeService;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        return employeeService.logout(request);
    }

    /**
     * 员工分页查询
     * @return Result<Employee>
     */
    @GetMapping("/page")
    public Result page(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize,
                       @RequestParam(value = "name",required = false) String name) {
        return employeeService.page(page,pageSize,name);
    }

    /**
     * 新增员工信息
     */
    @PostMapping
    public Result add(@RequestBody EnployeeDTO employee,HttpServletRequest request) {
        return employeeService.add(employee,request);
    }
}
