package com.example.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class SalesOrderVO implements Serializable {
    private static final long serialVersionUID = -6821445510705955332L;

    private Integer id;

    // 订单号
    private String orderNo;

    // 创建时间
    private Date createDate;

    // 订单状态
    private Integer orderStatus;

    // 修改时间
    private Date modifiedDate;

    // 用户id
    private Integer userId;

    // 订单金额
    private BigDecimal orderAmount;

    // 订单数量
    private Integer orderQuantity;

    private List<SalesOrderDetailVO> details;
}
