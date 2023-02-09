package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * dish
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.Dish菜品管理")
@Data
public class Dish implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 菜品名称
     */
    @ApiModelProperty(value="菜品名称")
    private String name;

    /**
     * 菜品分类id
     */
    @ApiModelProperty(value="菜品分类id")
    private Long categoryId;

    /**
     * 菜品价格
     */
    @ApiModelProperty(value="菜品价格")
    private BigDecimal price;

    /**
     * 商品码
     */
    @ApiModelProperty(value="商品码")
    private String code;

    /**
     * 图片
     */
    @ApiModelProperty(value="图片")
    private String image;

    /**
     * 描述信息
     */
    @ApiModelProperty(value="描述信息")
    private String description;

    /**
     * 0 停售 1 起售
     */
    @ApiModelProperty(value="0 停售 1 起售")
    private Integer status;

    /**
     * 顺序
     */
    @ApiModelProperty(value="顺序")
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