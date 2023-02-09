package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * address_book
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.ShoppingCart地址管理")
@Data
public class ShoppingCart implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty(value="用户id")
    private Long userId;

    /**
     * 收货人
     */
    @ApiModelProperty(value="收货人")
    private String consignee;

    /**
     * 性别 0 女 1 男
     */
    @ApiModelProperty(value="性别 0 女 1 男")
    private Byte sex;

    /**
     * 手机号
     */
    @ApiModelProperty(value="手机号")
    private String phone;

    /**
     * 省级区划编号
     */
    @ApiModelProperty(value="省级区划编号")
    private String provinceCode;

    /**
     * 省级名称
     */
    @ApiModelProperty(value="省级名称")
    private String provinceName;

    /**
     * 市级区划编号
     */
    @ApiModelProperty(value="市级区划编号")
    private String cityCode;

    /**
     * 市级名称
     */
    @ApiModelProperty(value="市级名称")
    private String cityName;

    /**
     * 区级区划编号
     */
    @ApiModelProperty(value="区级区划编号")
    private String districtCode;

    /**
     * 区级名称
     */
    @ApiModelProperty(value="区级名称")
    private String districtName;

    /**
     * 详细地址
     */
    @ApiModelProperty(value="详细地址")
    private String detail;

    /**
     * 标签
     */
    @ApiModelProperty(value="标签")
    private String label;

    /**
     * 默认 0 否 1是
     */
    @ApiModelProperty(value="默认 0 否 1是")
    private Boolean isDefault;

    /**
     * 创建时间
     */
    @ApiModelProperty(value="创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    private Date updateTime;

    /**
     * 创建人
     */
    @ApiModelProperty(value="创建人")
    private Long createUser;

    /**
     * 修改人
     */
    @ApiModelProperty(value="修改人")
    private Long updateUser;

    /**
     * 是否删除
     */
    @ApiModelProperty(value="是否删除")
    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}