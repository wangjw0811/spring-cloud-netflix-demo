package com.example.orderserver.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.entity.OrderSales;

/**
 * <p>
 * 销售订单表 Mapper 接口
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
public interface OrderSalesMapper extends BaseMapper<OrderSales> {

    Page<SalesOrderVO> getSalesOrdersWithDetails(Page page);

    SalesOrderVO getSalesOrderWithDetails(int id);

}
