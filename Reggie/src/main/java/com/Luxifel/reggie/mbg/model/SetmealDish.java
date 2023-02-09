package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * setmeal_dish
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.SetmealDish套餐菜品关系")
@Data
public class SetmealDish implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 套餐id 
     */
    @ApiModelProperty(value="套餐id ")
    private String setmealId;

    /**
     * 菜品id
     */
    @ApiModelProperty(value="菜品id")
    private String dishId;

    /**
     * 菜品名称 （冗余字段）
     */
    @ApiModelProperty(value="菜品名称 （冗余字段）")
    private String name;

    /**
     * 菜品原价（冗余字段）
     */
    @ApiModelProperty(value="菜品原价（冗余字段）")
    private BigDecimal price;

    /**
     * 份数
     */
    @ApiModelProperty(value="份数")
    private Integer copies;

    /**
     * 排序
     */
    @ApiModelProperty(value="排序")
    private Integer sort;

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