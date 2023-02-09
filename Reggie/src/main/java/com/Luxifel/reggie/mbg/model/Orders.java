package com.Luxifel.reggie.mbg.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * orders
 * @author 
 */
@ApiModel(value="com.Luxifel.reggie.mbg.model.Orders订单表")
@Data
public class Orders implements Serializable {
    /**
     * 主键
     */
    @ApiModelProperty(value="主键")
    private Long id;

    /**
     * 订单号
     */
    @ApiModelProperty(value="订单号")
    private String number;

    /**
     * 订单状态 1待付款，2待派送，3已派送，4已完成，5已取消
     */
    @ApiModelProperty(value="订单状态 1待付款，2待派送，3已派送，4已完成，5已取消")
    private Integer status;

    /**
     * 下单用户
     */
    @ApiModelProperty(value="下单用户")
    private Long userId;

    /**
     * 地址id
     */
    @ApiModelProperty(value="地址id")
    private Long addressBookId;

    /**
     * 下单时间
     */
    @ApiModelProperty(value="下单时间")
    private Date orderTime;

    /**
     * 结账时间
     */
    @ApiModelProperty(value="结账时间")
    private Date checkoutTime;

    /**
     * 支付方式 1微信,2支付宝
     */
    @ApiModelProperty(value="支付方式 1微信,2支付宝")
    private Integer payMethod;

    /**
     * 实收金额
     */
    @ApiModelProperty(value="实收金额")
    private BigDecimal amount;

    /**
     * 备注
     */
    @ApiModelProperty(value="备注")
    private String remark;

    private String phone;

    private String address;

    private String userName;

    private String consignee;

    private static final long serialVersionUID = 1L;
}