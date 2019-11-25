package com.example.web.controller;

import com.example.api.SalesOrderApi;
import com.example.api.dto.PostSalesOrder;
import com.example.api.vo.SalesOrderVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utils.ResponseData;

import java.util.List;

@RequestMapping("/web/order-sales")
@RestController
public class OrderController {
    @Autowired
    SalesOrderApi salesOrderApi;

    @PostMapping
    public ResponseData createSalesOrder(@RequestBody PostSalesOrder salesOrder){
        Integer id = salesOrderApi.createSalesOrder(salesOrder);
        if(id != null){
            return ResponseData.success(id);
        }
        return ResponseData.failure();
    }

    @GetMapping("/{id}")
    public ResponseData<SalesOrderVO> getSalesOrder(@PathVariable("id") int id){
        SalesOrderVO vo = salesOrderApi.getSalesOrder(id);
        return ResponseData.success(vo);
    }

    @GetMapping("/{current}/{size}")
    public ResponseData<SalesOrderVO> getSalesOrders(@PathVariable("current") int current, @PathVariable("size") int size){
        List<SalesOrderVO> vos = salesOrderApi.getSalesOrders(current, size);
        return ResponseData.success(vos);
    }

    @DeleteMapping("/{id}")
    public ResponseData deleteSalesOrder(@PathVariable("id") int id){
        boolean ok = salesOrderApi.deleteSalesOrder(id);
        if(ok){
            return ResponseData.success();
        }
        return ResponseData.failure();
    }
}
