package com.mingyang.reggie.controller;

import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.entity.Employee;
import com.mingyang.reggie.entity.dto.EmployeeDTO;
import com.mingyang.reggie.entity.dto.EmployeeLoginDTO;
import com.mingyang.reggie.service.impl.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "员工信息")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Resource
    private EmployeeService employeeService;

    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public Result login(HttpServletRequest request, @RequestBody EmployeeLoginDTO employee) {
        return employeeService.login(request, employee);
    }

    @ApiOperation(value = "登出")
    @PostMapping("/logout")
    public Result logout(HttpServletRequest request) {
        return employeeService.logout(request);
    }

    /**
     * 员工分页查询
     * @return Result<Employee>
     */
    @ApiOperation(value = "员工分页查询")
    @GetMapping(value = "/page", produces = "application/json;charset=UTF-8")
    public Result page(@RequestParam("page") Integer page,@RequestParam("pageSize") Integer pageSize,
                       @RequestParam(value = "name",required = false) String name) {
        return employeeService.page(page,pageSize,name);
    }

    /**
     * 新增员工信息
     */
    @ApiOperation(value = "新增员工信息")
    @PostMapping
    public Result add(@RequestBody EmployeeDTO employee, HttpServletRequest request) {
        return employeeService.add(employee,request);
    }

    /**
     * 根据id查询员工信息
     * @param id
     * @return Result<Employee>
     */
    @ApiOperation(value = "根据id查询员工信息")
    @GetMapping("/{id}")
    public Result get(@PathVariable("id") String id) {
        return employeeService.getEmployee(id);
    }

    /**
     * 修改员工信息
     * @param employee
     * @return Result<Employee>
     */
    @ApiOperation(value = "修改员工信息")
    @PutMapping
    public Result update(@RequestBody EmployeeDTO employee) {
        return employeeService.update(employee);
    }
}
