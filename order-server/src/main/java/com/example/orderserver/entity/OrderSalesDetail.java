package com.example.orderserver.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 销售订单明细表
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="OrderSalesDetail对象", description="销售订单明细表")
public class OrderSalesDetail implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "销售订单id")
    private Integer orderId;

    @ApiModelProperty(value = "商品id")
    private Integer productId;

    @ApiModelProperty(value = "商品编码")
    private String productCode;

    @ApiModelProperty(value = "商品名称")
    private String productName;

    @ApiModelProperty(value = "商品型号")
    private String productModel;

    @ApiModelProperty(value = "商品单价")
    private BigDecimal productPrice;

    @ApiModelProperty(value = "商品数量")
    private Integer productQuantity;

    @ApiModelProperty(value = "小计")
    private BigDecimal subtotal;


}
