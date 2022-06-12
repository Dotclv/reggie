package com.mingyang.reggie.common.enums;

import lombok.Getter;

/**
 * @author: ymy
 * @program: reggie
 * @description: 分类枚举类
 * @date: 2022/6/12 1:17
 * @version: 1.0
 */
public enum CategoryEnum {
    /** 菜品分类 */
    FOOD_CATEGORY(1, "菜品分类"),
    /** 套餐分类 */
    PACKAGE_CATEGORY(2, "套餐分类");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    CategoryEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}

