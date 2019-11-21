package com.example.orderserver.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.entity.OrderSales;

/**
 * <p>
 * 销售订单表 服务类
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
public interface IOrderSalesService extends IService<OrderSales> {

    Page<SalesOrderVO> getSalesOrdersWithDetails(int current, int size);

    SalesOrderVO getSalesOrderWithDetails(int id);

}
