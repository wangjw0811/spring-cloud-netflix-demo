package com.example.orderserver.service.impl;

import com.example.orderserver.entity.OrderSalesDetail;
import com.example.orderserver.mapper.OrderSalesDetailMapper;
import com.example.orderserver.service.IOrderSalesDetailService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 销售订单明细表 服务实现类
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
@Service
public class OrderSalesDetailServiceImpl extends ServiceImpl<OrderSalesDetailMapper, OrderSalesDetail> implements IOrderSalesDetailService {

}
