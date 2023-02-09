package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * dish_flavor
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.DishFlavor菜品口味关系表")
@Data
public class DishFlavor implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品
     */
    @ApiModelProperty(value="菜品")
    private Long dishId;

    /**
     * 口味名称
     */
    @ApiModelProperty(value="口味名称")
    private String name;

    /**
     * 口味数据list
     */
    @ApiModelProperty(value="口味数据list")
    private String value;

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