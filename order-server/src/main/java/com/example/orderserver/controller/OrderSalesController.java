package com.example.orderserver.controller;


import com.example.api.dto.PostSalesOrder;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.service.impl.OrderSalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private OrderSalesServiceImpl orderSalesService;

    @PostMapping
    public Integer createSalesOrder(@RequestBody PostSalesOrder salesOrder){
        Integer id = orderSalesService.createSalesOrder(salesOrder);
        return id;
    }

    @GetMapping("/{id}")
    public SalesOrderVO getSalesOrder(@PathVariable("id") int id){
        SalesOrderVO vo = orderSalesService.getSalesOrderWithDetails(id);
        return vo;
    }   
    
    @GetMapping("/{current}/{size}")
    public List<SalesOrderVO> getSalesOrders(@PathVariable("current") int current, @PathVariable("size") int size){
        List<SalesOrderVO> vos = orderSalesService.getSalesOrders(current, size);
        return vos;
    }

    @DeleteMapping("/{id}")
    public boolean deleteSalesOrder(@PathVariable("id") int id){
        return orderSalesService.deleteSalesOrder(id);
    }

}
