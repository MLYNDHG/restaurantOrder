package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * order_detail
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.OrderDetail订单明细表")
@Data
public class OrderDetail implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 名字
     */
    @ApiModelProperty(value="名字")
    private String name;

    /**
     * 图片
     */
    @ApiModelProperty(value="图片")
    private String image;

    /**
     * 订单id
     */
    @ApiModelProperty(value="订单id")
    private Long orderId;

    /**
     * 菜品id
     */
    @ApiModelProperty(value="菜品id")
    private Long dishId;

    /**
     * 套餐id
     */
    @ApiModelProperty(value="套餐id")
    private Long setmealId;

    /**
     * 口味
     */
    @ApiModelProperty(value="口味")
    private String dishFlavor;

    /**
     * 数量
     */
    @ApiModelProperty(value="数量")
    private Integer number;

    /**
     * 金额
     */
    @ApiModelProperty(value="金额")
    private BigDecimal amount;

    private static final long serialVersionUID = 1L;
}