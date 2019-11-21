package com.example.orderserver.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.api.dto.PostSalesOrder;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.service.impl.OrderSalesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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
    private OrderSalesServiceImpl orderSalesService;

    @PostMapping
    public ResponseData createSalesOrder(@RequestBody PostSalesOrder salesOrder){
        Integer id = orderSalesService.createSalesOrder(salesOrder);
        if(id != null){
            return ResponseData.success(id);
        }
        return ResponseData.failure();
    }

    @GetMapping("/{id}")
    public ResponseData<SalesOrderVO> getSalesOrder(@PathVariable int id){
        SalesOrderVO vo = orderSalesService.getSalesOrderWithDetails(id);
        return ResponseData.success(vo);
    }   
    
    @GetMapping("/{current}/{size}")
    public ResponseData<Page<SalesOrderVO>> getSalesOrders(@PathVariable int current, @PathVariable int size){
        List<SalesOrderVO> vos = orderSalesService.getSalesOrders(current, size);
        return ResponseData.success(vos);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteSalesOrder(@PathVariable int id){
        boolean ok = orderSalesService.deleteSalesOrder(id);
        if(ok){
            return ResponseData.success();
        }
        return ResponseData.failure();
    }

}
