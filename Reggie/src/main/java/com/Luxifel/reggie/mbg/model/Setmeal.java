package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * setmeal
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.Setmeal套餐")
@Data
public class Setmeal implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品分类id
     */
    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;

    /**
     * 套餐名称
     */
    @ApiModelProperty(value="套餐名称")
    private String name;

    /**
     * 套餐价格
     */
    @ApiModelProperty(value="套餐价格")
    private BigDecimal price;

    /**
     * 状态 0:停用 1:启用
     */
    @ApiModelProperty(value="状态 0:停用 1:启用")
    private Integer status;

    /**
     * 编码
     */
    @ApiModelProperty(value="编码")
    private String code;

    /**
     * 描述信息
     */
    @ApiModelProperty(value="描述信息")
    private String description;

    /**
     * 图片
     */
    @ApiModelProperty(value="图片")
    private String image;

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