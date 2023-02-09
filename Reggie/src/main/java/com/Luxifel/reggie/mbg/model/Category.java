package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * category
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.Category菜品及套餐分类")
@Data
public class Category implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 类型   1 菜品分类 2 套餐分类
     */
    @ApiModelProperty(value="类型   1 菜品分类 2 套餐分类")
    private Integer type;

    /**
     * 分类名称
     */
    @ApiModelProperty(value="分类名称")
    private String name;

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

    private static final long serialVersionUID = 1L;
}