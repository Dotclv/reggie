package com.mingyang.reggie.common.model;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: ymy
 * @program: reggie
 * @description:
 * @date: 2022/6/10 23:34
 * @version: 1.0
 */
@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 2517058123565966064L;
    /**
     * 创建时间
     */
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "update_time",fill = FieldFill.INSERT_UPDATE)
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @TableField(value = "create_user")
    @ApiModelProperty(value = "创建人")
    private Long createUser;

    /**
     * 修改人
     */
    @TableField(value = "update_user")
    @ApiModelProperty(value = "修改人")
    private Long updateUser;

    /**
     * 是否删除
     */
    @TableField(value = "is_deleted")
    @ApiModelProperty(value = "是否删除")
    private Integer isDeleted;

    public static final String COL_CREATE_TIME = "create_time";

    public static final String COL_UPDATE_TIME = "update_time";

    public static final String COL_CREATE_USER = "create_user";

    public static final String COL_UPDATE_USER = "update_user";

    public static final String COL_IS_DELETED = "is_deleted";
}
