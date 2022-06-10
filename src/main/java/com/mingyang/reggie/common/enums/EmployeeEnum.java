package com.mingyang.reggie.common.enums;

import lombok.Getter;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/11 1:21
 * @version: 1.0
 */
public enum EmployeeEnum {
    EMPLOYEE_ID_STATUS_NORMAL(1, "正常"),
    EMPLOYEE_ID_STATUS_DISABLE(0, "禁用");

    @Getter
    private Integer code;
    @Getter
    private String msg;

    EmployeeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
