package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
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
    * 套餐菜品关系
    */
@ApiModel(value="套餐菜品关系")
@Data
@Builder
@TableName(value = "setmeal_dish")
public class SetmealDish {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 套餐id 
     */
    @TableField(value = "setmeal_id")
    @ApiModelProperty(value="套餐id ")
    private String setmealId;

    /**
     * 菜品id
     */
    @TableField(value = "dish_id")
    @ApiModelProperty(value="菜品id")
    private String dishId;

    /**
     * 菜品名称 （冗余字段）
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="菜品名称 （冗余字段）")
    private String name;

    /**
     * 菜品原价（冗余字段）
     */
    @TableField(value = "price")
    @ApiModelProperty(value="菜品原价（冗余字段）")
    private BigDecimal price;

    /**
     * 份数
     */
    @TableField(value = "copies")
    @ApiModelProperty(value="份数")
    private Integer copies;

    /**
     * 排序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="排序")
    private Integer sort;

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

    public static final String COL_SETMEAL_ID = "setmeal_id";

    public static final String COL_DISH_ID = "dish_id";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_COPIES = "copies";

    public static final String COL_SORT = "sort";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_UPDATE_USER = "update_user";

    public static final String COL_IS_DELETED = "is_deleted";
}