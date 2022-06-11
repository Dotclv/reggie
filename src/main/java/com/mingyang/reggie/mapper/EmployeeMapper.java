package com.mingyang.reggie.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mingyang.reggie.entity.Employee;
import java.util.List;

import com.mingyang.reggie.entity.dto.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper<Employee> {
    int updateBatch(List<Employee> list);

    int batchInsert(@Param("list") List<Employee> list);

    Page<EmployeeDTO> page(Page<Employee> employeePage,@Param(Constants.WRAPPER) QueryWrapper<Employee> wrapper);
}