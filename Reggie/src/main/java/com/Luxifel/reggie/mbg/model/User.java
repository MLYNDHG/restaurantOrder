package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

/**
 * user
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.User用户信息")
@Data
public class User implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value="姓名")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 身份证号
     */
    @ApiModelProperty(value="身份证号")
    private String idNumber;

    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String avatar;

    /**
     * 状态 0:禁用，1:正常
     */
    @ApiModelProperty(value="状态 0:禁用，1:正常")
    private Integer status;

    private static final long serialVersionUID = 1L;
}