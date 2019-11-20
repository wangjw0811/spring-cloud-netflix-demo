package com.example.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PutSalesOrderDetail implements Serializable {
    private static final long serialVersionUID = -191555496357275229L;

    @NotBlank(message = "id")
    private Integer id;

    @NotNull(message = "销售订单id")
    private Integer orderId;

    @NotNull(message = "商品id")
    private Integer productId;

    @NotNull(message = "商品编码")
    private String productCode;

    @NotNull(message = "商品名称")
    private String productName;

    @NotNull(message = "商品型号")
    private String productModel;

    @NotNull(message = "商品单价")
    private BigDecimal productPrice;

    @NotNull(message = "商品数量")
    private Integer productQuantity;

    @NotNull(message = "小计")
    private BigDecimal subtotal;

}
