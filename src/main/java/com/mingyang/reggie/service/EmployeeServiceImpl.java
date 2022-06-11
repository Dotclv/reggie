package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.common.utils.MD5Util;
import com.mingyang.reggie.entity.dto.EmployeeDTO;
import com.mingyang.reggie.entity.dto.EmployeeLoginDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
@Slf4j
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

    /**
     * 登录
     * @param request  HttpServletRequest
     * @param employee Employee
     * @return Result<Employee>
     */
    @Override
    public Result login(HttpServletRequest request, EmployeeLoginDTO employee) {
        // 将密码进行MD5加密
        employee.setPassword(MD5Util.MD5(employee.getPassword()));
        // 根据用户名查数据库
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Employee::getUsername, employee.getUsername());
        Employee emp = baseMapper.selectOne(wrapper);
        if(emp == null) {
            return Result.failure(ResultCode.USER_NOT_EXIST_ERROR);
        }
        // 判断密码是否正确
        if(!emp.getPassword().equals(employee.getPassword())) {
            return Result.failure(ResultCode.USER_NAME_OR_PASSWORD_ERROR);
        }
        // 查看是否被禁用
        if(emp.getStatus() == 0) {
            return Result.failure(ResultCode.USER_DISABLE);
        }
        // 将用户信息存入session
        request.getSession().setAttribute(EntityConstant.USER_LOGIN_SESSION_KEY, emp.getId());
        log.info("用户 {} 登录成功", emp.getUsername());
        return Result.success(emp);
    }

    /**
     * 登出
     * @param request   HttpServletRequest
     * @return Result<Employee>
     */
    @Override
    public Result logout(HttpServletRequest request) {
        // 清除session
        request.getSession().removeAttribute(EntityConstant.USER_LOGIN_SESSION_KEY);
        log.info("用户登出");
        return Result.success();
    }

    @Override
    public Result page(Integer page, Integer size, String name) {
        Page<Employee> employeePage = new Page<>(page, size);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Employee::getIsDeleted,EntityConstant.IS_NOT_DELETED)
                        .like(StringUtils.isNotEmpty(name), Employee::getName, name)
                        .orderByDesc(Employee::getUpdateTime);
        Page<EmployeeDTO> selectPage = baseMapper.page(employeePage, wrapper);
        return Result.success(selectPage);
    }

    @Override
    public Result add(EmployeeDTO employee, HttpServletRequest request) {
        Employee toEmployee = EmployeeDTO.convertToEmployee(employee);
        toEmployee.setPassword(MD5Util.MD5(EntityConstant.INIT_PASSWORD));
        return this.save(toEmployee) ? Result.success() : Result.failure(ResultCode.USER_ADD_ERROR);
    }

    @Override
    public Result update(EmployeeDTO employee) {
        Employee toEmployee = EmployeeDTO.convertToEmployee(employee);
        return this.updateById(toEmployee) ? Result.success() : Result.failure(ResultCode.PARAM_ERROR);
    }

    @Override
    public Result getEmployee(String id) {
        Employee employee = baseMapper.selectById(id);
        EmployeeDTO toEmployeeDTO = EmployeeDTO.convertToEmployeeDTO(employee);
        return Result.success(toEmployeeDTO);
    }
}
