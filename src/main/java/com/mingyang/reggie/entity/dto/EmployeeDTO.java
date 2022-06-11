package com.mingyang.reggie.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mingyang.reggie.common.constant.EntityConstant;
import com.mingyang.reggie.common.enums.EmployeeEnum;
import com.mingyang.reggie.common.model.JsonLongSerializer;
import com.mingyang.reggie.entity.Employee;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/11 1:53
 * @version: 1.0
 */
@Data
@ApiModel(value = "员工信息")
public class EmployeeDTO {
    @JsonSerialize(using = JsonLongSerializer.class )
    @ApiModelProperty(value="姓名")
    private Long id;
    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idNumber;

    /**
     * 状态 0:禁用，1:正常
     */
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;

    public static Employee convertToEmployee(EmployeeDTO item) {
        if (item == null) {
            return null;
        }
        Employee result = new Employee();
        if(item.getId() != null) {
            result.setId(item.getId());
        }
        result.setName(item.getName());
        result.setUsername(item.getUsername());
        result.setPassword(item.getUsername());
        result.setPhone(item.getPhone());
        result.setSex(item.getSex());
        result.setIdNumber(item.getIdNumber());
        result.setStatus(EmployeeEnum.EMPLOYEE_ID_STATUS_NORMAL.getCode());
        result.setIsDeleted(EntityConstant.IS_NOT_DELETED);
        result.setStatus(item.getStatus());
        return result;
    }

    public static EmployeeDTO convertToEmployeeDTO(Employee item) {
        if (item == null) {
            return null;
        }
        EmployeeDTO result = new EmployeeDTO();
        result.setId(item.getId());
        result.setName(item.getName());
        result.setUsername(item.getUsername());
        result.setPassword(item.getPassword());
        result.setPhone(item.getPhone());
        result.setSex(item.getSex());
        result.setIdNumber(item.getIdNumber());
        result.setStatus(item.getStatus());
        return result;
    }
}
