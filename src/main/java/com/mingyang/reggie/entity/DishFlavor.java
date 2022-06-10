package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
/**
    * 菜品口味关系表
    */
@ApiModel(value="菜品口味关系表")
@Data
@Builder
@TableName(value = "dish_flavor")
public class DishFlavor {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品
     */
    @TableField(value = "dish_id")
    @ApiModelProperty(value="菜品")
    private Long dishId;

    /**
     * 口味名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="口味名称")
    private String name;

    /**
     * 口味数据list
     */
    @TableField(value = "`value`")
    @ApiModelProperty(value="口味数据list")
    private String value;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time")
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    @ApiModelProperty(value="创建人")
    private Long createUser;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    @ApiModelProperty(value="修改人")
    private Long updateUser;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    @ApiModelProperty(value="是否删除")
    private Integer isDeleted;

    public static final String COL_ID = "id";

    public static final String COL_DISH_ID = "dish_id";

    public static final String COL_NAME = "name";

    public static final String COL_VALUE = "value";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_UPDATE_USER = "update_user";

    public static final String COL_IS_DELETED = "is_deleted";
}