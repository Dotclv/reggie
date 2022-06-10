package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mingyang.reggie.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
/**
    * 员工信息
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="员工信息")
@Data
@Builder
@TableName(value = "employee")
public class Employee extends BaseEntity {
    private static final long serialVersionUID = 6787847893564790628L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 姓名
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 用户名
     */
    @TableField(value = "username")
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "`password`")
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 性别
     */
    @TableField(value = "sex")
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 身份证号
     */
    @TableField(value = "id_number")
    @ApiModelProperty(value="身份证号")
    private String idNumber;

    /**
     * 状态 0:禁用，1:正常
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_USERNAME = "username";

    public static final String COL_PASSWORD = "password";

    public static final String COL_PHONE = "phone";

    public static final String COL_SEX = "sex";

    public static final String COL_ID_NUMBER = "id_number";

    public static final String COL_STATUS = "status";
}