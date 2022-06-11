package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.mingyang.reggie.common.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
    * 菜品口味关系表
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="菜品口味关系表")
@Data
@NoArgsConstructor
@TableName(value = "dish_flavor")
public class DishFlavor extends BaseEntity {
    private static final long serialVersionUID = -7773662140035169831L;
    /**
     * 主键
     */
    @TableId(value = "id")
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
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

    public static final String COL_ID = "id";

    public static final String COL_DISH_ID = "dish_id";

    public static final String COL_NAME = "name";

    public static final String COL_VALUE = "value";

}