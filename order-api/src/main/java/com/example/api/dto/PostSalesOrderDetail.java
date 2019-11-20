package com.example.api.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class PostSalesOrderDetail implements Serializable {
    private static final long serialVersionUID = 5328663911917875632L;

    @NotNull(message = "商品id不能为空")
    private Integer productId;

    @NotNull(message = "商品编码不能为空")
    private String productCode;

    @NotNull(message = "商品名称不能为空")
    private String productName;

    @NotNull(message = "商品型号不能为空")
    private String productModel;

    @NotNull(message = "商品单价不能为空")
    private BigDecimal productPrice;

    @NotNull(message = "商品数量不能为空")
    private Integer productQuantity;

    @NotNull(message = "小计不能为空")
    private BigDecimal subtotal;
}
