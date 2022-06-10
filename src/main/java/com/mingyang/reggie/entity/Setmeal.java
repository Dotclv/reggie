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
    * 套餐
    */
@ApiModel(value="套餐")
@Data
@Builder
@TableName(value = "setmeal")
public class Setmeal {
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
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

    public static final String COL_CATEGORY_ID = "category_id";

    public static final String COL_NAME = "name";

    public static final String COL_PRICE = "price";

    public static final String COL_STATUS = "status";

    public static final String COL_CODE = "code";

    public static final String COL_DESCRIPTION = "description";

    public static final String COL_IMAGE = "image";

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_UPDATE_USER = "update_user";

    public static final String COL_IS_DELETED = "is_deleted";
}