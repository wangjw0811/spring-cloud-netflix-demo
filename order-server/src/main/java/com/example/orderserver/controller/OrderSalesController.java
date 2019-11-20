package com.example.orderserver.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.api.vo.SalesOrderDetailVO;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.service.IOrderSalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.ResponseData;

import java.util.List;

/**
 * <p>
 * 销售订单表 前端控制器
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
@RestController
@RequestMapping("/order-sales")
public class OrderSalesController {
    
    @Autowired
    private IOrderSalesService orderSalesService;
    
    @GetMapping("/{current}/{size}")
    public ResponseData<List<SalesOrderDetailVO>> getSalesOrders(@PathVariable int current, @PathVariable int size){
        Page<SalesOrderVO> salesOrder = orderSalesService.getSalesOrder(current, size);
        List<SalesOrderVO> records = salesOrder.getRecords();
        return ResponseData.success(records);
    }

}
