package com.mingyang.reggie.entity.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/12 1:22
 * @version: 1.0
 */
@ApiModel(value = "CategoryPageVO", description = "分类分页VO")
@Data
public class CategoryPageVO {

    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 类型   1 菜品分类 2 套餐分类
     */
    @ApiModelProperty(value="类型   1 菜品分类 2 套餐分类")
    private Integer type;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String name;

    /**
     * 顺序
     */
    @ApiModelProperty(value="顺序")
    private Integer sort;

    /**
     * 更新时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
