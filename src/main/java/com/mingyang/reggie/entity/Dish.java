package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
    * 菜品管理
    */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="菜品管理")
@Data
@NoArgsConstructor
@TableName(value = "dish")
public class Dish extends BaseEntity {
    private static final long serialVersionUID = -1591621278374471729L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品名称
     */
    @TableField(value = "`name`")
    @ApiModelProperty(value="菜品名称")
    private String name;

    /**
     * 菜品分类id
     */
    @TableField(value = "category_id")
    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;

    /**
     * 一般商品的价格在数据库中存储的单位 是分（分、角、元）
     */
    @TableField(value = "price")
    @ApiModelProperty(value="一般商品的价格在数据库中存储的单位 是分（分、角、元）")
    private BigDecimal price;

    /**
     * 商品码
     */
    @TableField(value = "code")
    @ApiModelProperty(value="商品码")
    private String code;

    /**
     * 图片
     */
    @TableField(value = "image")
    @ApiModelProperty(value="图片")
    private String image;

    /**
     * 描述信息
     */
    @TableField(value = "description")
    @ApiModelProperty(value="描述信息")
    private String description;

    /**
     * 0 停售 1 起售
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="0 停售 1 起售")
    private Integer status;

    /**
     * 顺序
     */
    @TableField(value = "sort")
    @ApiModelProperty(value="顺序")
    private Integer sort;

    public static final String COL_ID = "id";

    public static final String COL_NAME = "name";

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_PRICE = "price";

    public static final String COL_CODE = "code";

    public static final String COL_IMAGE = "image";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_STATUS = "status";

    public static final String COL_SORT = "sort";
}