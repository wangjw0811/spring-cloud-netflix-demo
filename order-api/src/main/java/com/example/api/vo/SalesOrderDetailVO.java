package com.example.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SalesOrderDetailVO implements Serializable {
    private static final long serialVersionUID = -8774053965241788098L;

    private Integer id;

    // 销售订单id
    private Integer orderId;

    // 商品id
    private Integer productId;

    // 商品编码
    private String productCode;

    // 商品名称
    private String productName;

    // 商品型号
    private String productModel;

    // 商品单价
    private BigDecimal productPrice;

    // 商品数量
    private Integer productQuantity;

    // 小计
    private BigDecimal subtotal;
}
