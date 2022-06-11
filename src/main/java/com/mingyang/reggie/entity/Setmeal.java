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
    * 套餐
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="套餐")
@Data
@NoArgsConstructor
@TableName(value = "setmeal")
public class Setmeal extends BaseEntity {
    private static final long serialVersionUID = -5195378996478612659L;
    /**
     * 主键
     */
    @TableId(value = "id")
    @TableField(fill = FieldFill.INSERT)
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;

    /**
     * 套餐名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="套餐名称")
    private String name;

    /**
     * 套餐价格
     */
    @TableField(value = "price")
    @ApiModelProperty(value="套餐价格")
    private BigDecimal price;

    /**
     * 状态 0:停用 1:启用
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="状态 0:停用 1:启用")
    private Integer status;

    /**
     * 编码
     */
    @TableField(value = "code")
    @ApiModelProperty(value="编码")
    private String code;

    /**
     * 描述信息
     */
    @TableField(value = "description")
    @ApiModelProperty(value="描述信息")
    private String description;

    /**
     * 图片
     */
    @TableField(value = "image")
    @ApiModelProperty(value="图片")
    private String image;

    public static final String COL_ID = "id";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_STATUS = "status";

    public static final String COL_CODE = "code";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_IMAGE = "image";
}