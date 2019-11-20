package com.example.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PostSalesOrder implements Serializable {
    private static final long serialVersionUID = -8597254672574909654L;
    @NotBlank(message = "用户id不能为空")
    private Integer userId;

    @NotBlank(message = "订单金额不能为空")
    private BigDecimal orderAmount;

    @NotBlank(message = "订单数量不能为空")
    private Integer orderQuantity;

    private List<PostSalesOrderDetail> details;
}
