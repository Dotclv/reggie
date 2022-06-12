package com.mingyang.reggie.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 2:13
 * @version: 1.0
 */
@Data
public class DishPageVO {
    @ApiModelProperty(value="主键")
    private Long id;

    @ApiModelProperty(value="菜品名称")
    private String name;

    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;

    @ApiModelProperty(value="菜品分类")
    private String categoryName;

    @ApiModelProperty(value="一般商品的价格在数据库中存储的单位 是分（分、角、元）")
    private BigDecimal price;

    @ApiModelProperty(value="0 停售 1 起售")
    private Integer status;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
