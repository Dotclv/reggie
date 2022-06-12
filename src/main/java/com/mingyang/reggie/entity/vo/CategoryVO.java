package com.mingyang.reggie.entity.vo;

import com.mingyang.reggie.entity.Category;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: ymy
 * @program: reggie
 * @description: 分类
 * @date: 2022/6/12 1:40
 * @version: 1.0
 */
@ApiModel(value = "CategoryVO", description = "分类")
@Data
public class CategoryVO {

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

    public static Category convertToCategoryVO(CategoryVO item) {
        if (item == null) {
            return null;
        }
        Category result = new Category();
        if(item.getId() != null) {
            result.setId(item.getId());
        }
        result.setType(item.getType());
        result.setName(item.getName());
        result.setSort(item.getSort());
        return result;
    }

    public static CategoryVO convertToCategoryVO(Category item) {
        if (item == null) {
            return null;
        }
        CategoryVO result = new CategoryVO();
        result.setId(item.getId());
        result.setType(item.getType());
        result.setName(item.getName());
        result.setSort(item.getSort());
        return result;
    }
}
