package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mingyang.reggie.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
/**
    * 订单明细表
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="订单明细表")
@Data
@NoArgsConstructor
@TableName(value = "order_detail")
public class OrderDetail extends BaseEntity {
    private static final long serialVersionUID = 5643788198348820947L;
    /**
     * 主键
     */
    @TableId(value = "id")
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 名字
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="名字")
    private String name;

    /**
     * 图片
     */
    @TableField(value = "image")
    @ApiModelProperty(value="图片")
    private String image;

    /**
     * 订单id
     */
    @TableField(value = "order_id")
    @ApiModelProperty(value="订单id")
    private Long orderId;

    /**
     * 菜品id
     */
    @TableField(value = "dish_id")
    @ApiModelProperty(value="菜品id")
    private Long dishId;

    /**
     * 套餐id
     */
    @TableField(value = "setmeal_id")
    @ApiModelProperty(value="套餐id")
    private Long setmealId;

    /**
     * 口味
     */
    @TableField(value = "dish_flavor")
    @ApiModelProperty(value="口味")
    private String dishFlavor;

    /**
     * 数量
     */
    @TableField(value = "`number`")
    @ApiModelProperty(value="数量")
    private Integer number;

    /**
     * 金额
     */
    @TableField(value = "amount")
    @ApiModelProperty(value="金额")
    private BigDecimal amount;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_IMAGE = "image";

    public static final String COL_ORDER_ID = "order_id";

    public static final String COL_DISH_ID = "dish_id";

    public static final String COL_SETMEAL_ID = "setmeal_id";

    public static final String COL_DISH_FLAVOR = "dish_flavor";

    public static final String COL_NUMBER = "number";

    public static final String COL_AMOUNT = "amount";
}