package com.mingyang.reggie.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 20:24
 * @version: 1.0
 */
@ApiModel(value = "SetMealPageVO", description = "套餐分页VO")
@Data
public class SetMealPageVO {
    @ApiModelProperty(value="主键")
    private Long id;
    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;
    @ApiModelProperty(value="菜品分类")
    private String categoryName;
    @ApiModelProperty(value="套餐名称")
    private String name;
    @ApiModelProperty(value="套餐价格")
    private BigDecimal price;
    @ApiModelProperty(value="状态 0:停用 1:启用")
    private Integer status;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
