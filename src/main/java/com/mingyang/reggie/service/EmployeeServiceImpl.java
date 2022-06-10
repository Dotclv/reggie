package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.common.utils.MD5Util;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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

    /**
     * 登录
     * @param request  HttpServletRequest
     * @param employee Employee
     * @return Result<Employee>
     */
    @Override
    public Result login(HttpServletRequest request, Employee employee) {
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
        request.getSession().setAttribute("employee", emp.getId());
        return Result.success(emp);
    }
}
