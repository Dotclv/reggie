package com.mingyang.reggie.entity;

import com.baomidou.mybatisplus.annotation.*;
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
 * @date: 2022/6/10 22:53
 * @version: 1.0
 */

/**
 * 地址管理
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "地址管理")
@Data
@NoArgsConstructor
@TableName(value = "address_book")
public class AddressBook extends BaseEntity {
    private static final long serialVersionUID = 4739265794925473130L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private Long id;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value = "用户id")
    private Long userId;

    /**
     * 收货人
     */
    @TableField(value = "consignee")
    @ApiModelProperty(value = "收货人")
    private String consignee;

    /**
     * 性别 0 女 1 男
     */
    @TableField(value = "sex")
    @ApiModelProperty(value = "性别 0 女 1 男")
    private Byte sex;

    /**
     * 手机号
     */
    @TableField(value = "phone")
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 省级区划编号
     */
    @TableField(value = "province_code")
    @ApiModelProperty(value = "省级区划编号")
    private String provinceCode;

    /**
     * 省级名称
     */
    @TableField(value = "province_name")
    @ApiModelProperty(value = "省级名称")
    private String provinceName;

    /**
     * 市级区划编号
     */
    @TableField(value = "city_code")
    @ApiModelProperty(value = "市级区划编号")
    private String cityCode;

    /**
     * 市级名称
     */
    @TableField(value = "city_name")
    @ApiModelProperty(value = "市级名称")
    private String cityName;

    /**
     * 区级区划编号
     */
    @TableField(value = "district_code")
    @ApiModelProperty(value = "区级区划编号")
    private String districtCode;

    /**
     * 区级名称
     */
    @TableField(value = "district_name")
    @ApiModelProperty(value = "区级名称")
    private String districtName;

    /**
     * 详细地址
     */
    @TableField(value = "detail")
    @ApiModelProperty(value = "详细地址")
    private String detail;

    /**
     * 标签
     */
    @TableField(value = "`label`")
    @ApiModelProperty(value = "标签")
    private String label;

    /**
     * 默认 0 否 1是
     */
    @TableField(value = "is_default")
    @ApiModelProperty(value = "默认 0 否 1是")
    private Boolean isDefault;


    public static final String COL_ID = "id";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_CONSIGNEE = "consignee";

    public static final String COL_SEX = "sex";

    public static final String COL_PHONE = "phone";

    public static final String COL_PROVINCE_CODE = "province_code";

    public static final String COL_PROVINCE_NAME = "province_name";

    public static final String COL_CITY_CODE = "city_code";

    public static final String COL_CITY_NAME = "city_name";

    public static final String COL_DISTRICT_CODE = "district_code";

    public static final String COL_DISTRICT_NAME = "district_name";

    public static final String COL_DETAIL = "detail";

    public static final String COL_LABEL = "label";

    public static final String COL_IS_DEFAULT = "is_default";

}