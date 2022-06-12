package com.mingyang.reggie.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 22:04
 * @version: 1.0
 */
@Data
public class OrdersPageVO {
    @ApiModelProperty(value="主键")
    private Long id;
    @ApiModelProperty(value="订单号")
    private String number;
    @ApiModelProperty(value="订单状态 1待付款，2待派送，3已派送，4已完成，5已取消")
    private Integer status;
    @ApiModelProperty(value="下单用户")
    private Long userId;
    @ApiModelProperty(value="下单用户")
    private String userName;
    @ApiModelProperty(value="手机号")
    private String phone;
    @ApiModelProperty(value="地址id")
    private Long addressBookId;
    @ApiModelProperty(value="地址")
    private Long detail;
    @ApiModelProperty(value="下单时间")
    private Date orderTime;
    @ApiModelProperty(value="实收金额")
    private BigDecimal amount;
}
