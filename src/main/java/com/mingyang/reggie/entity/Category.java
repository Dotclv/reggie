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
    * 菜品及套餐分类
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="菜品及套餐分类")
@Data
@NoArgsConstructor
@TableName(value = "category")
public class Category extends BaseEntity {
    private static final long serialVersionUID = -2669322959272111304L;
    /**
     * 主键
     */
    @TableId(value = "id")
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 类型   1 菜品分类 2 套餐分类
     */
    @TableField(value = "`type`")
    @ApiModelProperty(value="类型   1 菜品分类 2 套餐分类")
    private Integer type;

    /**
     * 分类名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="分类名称")
    private String name;

    /**
     * 顺序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="顺序")
    private Integer sort;

    public static final String COL_ID = "id";

    public static final String COL_TYPE = "type";

    public static final String COL_NAME = "name";

    public static final String COL_SORT = "sort";
}