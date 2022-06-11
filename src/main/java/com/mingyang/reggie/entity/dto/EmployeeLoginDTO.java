package com.mingyang.reggie.entity.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/11 14:33
 * @version: 1.0
 */
@ApiModel(value = "登录信息")
@Data
public class EmployeeLoginDTO {
    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;
    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;
    /**
     * 验证码
     */
    @ApiModelProperty(value="验证码")
    private String captcha;
}
