package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mingyang.reggie.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
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
    * 套餐菜品关系
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="套餐菜品关系")
@Data
@NoArgsConstructor
@TableName(value = "setmeal_dish")
public class SetmealDish extends BaseEntity {
    private static final long serialVersionUID = -2581231509513561008L;
    /**
     * 主键
     */
    @TableId(value = "id")
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
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

    public static final String COL_ID = "id";

    public static final String COL_SETMEAL_ID = "setmeal_id";

    public static final String COL_DISH_ID = "dish_id";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_COPIES = "copies";

    public static final String COL_SORT = "sort";
}