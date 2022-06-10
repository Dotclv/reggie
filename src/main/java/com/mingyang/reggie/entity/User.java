package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.mingyang.reggie.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    * 用户信息
 * @author 36995
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="用户信息")
@Data
@Builder
@TableName(value = "`user`")
public class User extends BaseEntity {
    private static final long serialVersionUID = -656933883974051470L;
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
     * 头像
     */
    @TableField(value = "avatar")
    @ApiModelProperty(value="头像")
    private String avatar;

    /**
     * 状态 0:禁用，1:正常
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_PHONE = "phone";

    public static final String COL_SEX = "sex";

    public static final String COL_ID_NUMBER = "id_number";

    public static final String COL_AVATAR = "avatar";

    public static final String COL_STATUS = "status";
}