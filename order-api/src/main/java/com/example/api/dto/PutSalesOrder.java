package com.example.api.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class PutSalesOrder implements Serializable {
    private static final long serialVersionUID = 1433046129331041403L;

    @NotBlank(message = "id不能为空")
    private Integer id;

    @NotNull(message = "订单金额")
    private BigDecimal orderAmount;

    @NotNull(message = "订单数量")
    private Integer orderQuantity;

    private List<PutSalesOrderDetail> details;
}
