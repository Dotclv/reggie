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

/**
 * @author:  ymy
 * @program: reggie
 * @description: ${description}
 * @date: 2022/6/10 22:52
 * @version: 1.0
 */
/**
    * 订单表
 * @author 36995
 */
@EqualsAndHashCode(callSuper = true)
@ApiModel(value="订单表")
@Data
@Builder
@TableName(value = "orders")
public class Orders extends BaseEntity {
    private static final long serialVersionUID = 7068063419683607841L;
    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 订单号
     */
    @TableField(value = "`number`")
    @ApiModelProperty(value="订单号")
    private String number;

    /**
     * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
     */
    @TableField(value = "`status`")
    @ApiModelProperty(value="订单状态 1待付款，2待派送，3已派送，4已完成，5已取消")
    private Integer status;

    /**
     * 下单用户
     */
    @TableField(value = "user_id")
    @ApiModelProperty(value="下单用户")
    private Long userId;

    /**
     * 地址id
     */
    @TableField(value = "address_book_id")
    @ApiModelProperty(value="地址id")
    private Long addressBookId;

    /**
     * 下单时间
     */
    @TableField(value = "order_time")
    @ApiModelProperty(value="下单时间")
    private Date orderTime;

    /**
     * 结账时间
     */
    @TableField(value = "checkout_time")
    @ApiModelProperty(value="结账时间")
    private Date checkoutTime;

    /**
     * 支付方式 1微信,2支付宝
     */
    @TableField(value = "pay_method")
    @ApiModelProperty(value="支付方式 1微信,2支付宝")
    private Integer payMethod;

    /**
     * 实收金额
     */
    @TableField(value = "amount")
    @ApiModelProperty(value="实收金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @TableField(value = "remark")
    @ApiModelProperty(value="备注")
    private String remark;

    @TableField(value = "phone")
    @ApiModelProperty(value="")
    private String phone;

    @TableField(value = "address")
    @ApiModelProperty(value="")
    private String address;

    @TableField(value = "user_name")
    @ApiModelProperty(value="")
    private String userName;

    @TableField(value = "consignee")
    @ApiModelProperty(value="")
    private String consignee;

    public static final String COL_ID = "id";

    public static final String COL_NUMBER = "number";

    public static final String COL_STATUS = "status";

    public static final String COL_USER_ID = "user_id";

    public static final String COL_ADDRESS_BOOK_ID = "address_book_id";

    public static final String COL_ORDER_TIME = "order_time";

    public static final String COL_CHECKOUT_TIME = "checkout_time";

    public static final String COL_PAY_METHOD = "pay_method";

    public static final String COL_AMOUNT = "amount";

    public static final String COL_REMARK = "remark";

    public static final String COL_PHONE = "phone";

    public static final String COL_ADDRESS = "address";

    public static final String COL_USER_NAME = "user_name";

    public static final String COL_CONSIGNEE = "consignee";
}