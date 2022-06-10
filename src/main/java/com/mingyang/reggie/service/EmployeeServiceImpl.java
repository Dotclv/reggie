package com.mingyang.reggie.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.enums.EmployeeEnum;
import com.mingyang.reggie.common.result.Result;
import com.mingyang.reggie.common.result.ResultCode;
import com.mingyang.reggie.common.utils.JsonTool;
import com.mingyang.reggie.common.utils.MD5Util;
import com.mingyang.reggie.entity.dto.EnployeeDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.List;
import com.mingyang.reggie.mapper.EmployeeMapper;
import com.mingyang.reggie.entity.Employee;
import com.mingyang.reggie.service.impl.EmployeeService;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

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
        request.getSession().removeAttribute("employee");
        log.info("用户登出");
        return Result.success();
    }

    @Override
    public Result page(Integer page, Integer size, String name) {
        Page<Employee> employeePage = new Page<>(page, size);
        QueryWrapper<Employee> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Employee::getIsDeleted,EntityConstant.IS_NOT_DELETED)
                        .like(StringUtils.isNotEmpty(name), Employee::getUsername, name)
                        .orderByDesc(Employee::getCreateTime);
        Page<Employee> selectPage = baseMapper.selectPage(employeePage, wrapper);
        return Result.success(selectPage);
    }

    @Override
    public Result add(EnployeeDTO employee,HttpServletRequest request) {
        Employee toEmployee = EnployeeDTO.convertToEmployee(employee);
//        Object attribute = request.getSession().getAttribute("employee");
//        Employee parse = JsonTool.parse(JsonTool.toJson(attribute), Employee.class);
        toEmployee.setCreateUser(1L);
        toEmployee.setUpdateUser(1L);
        toEmployee.setPassword(MD5Util.MD5(toEmployee.getPassword()));
        int insert = baseMapper.insert(toEmployee);
        return insert >0 ? Result.success() : Result.failure(ResultCode.USER_ADD_ERROR);
    }
}
