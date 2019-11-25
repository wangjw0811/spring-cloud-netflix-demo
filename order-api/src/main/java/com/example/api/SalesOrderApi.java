package com.example.api;

import com.example.api.dto.PostSalesOrder;
import com.example.api.dto.PutSalesOrder;
import com.example.api.vo.SalesOrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order-server", fallbackFactory = SalesOrderFallBackFactory.class, primary = false)
public interface SalesOrderApi {

    @PostMapping(value = "/api/order-sales")
    Integer createSalesOrder(PostSalesOrder salesOrder);

    @DeleteMapping(value = "/api/order-sales/{id}")
    boolean deleteSalesOrder(@PathVariable("id") int id);

    @PutMapping(value = "/api/order-sales")
    Integer updateSalesOrder(PutSalesOrder salesOrder);

    @GetMapping(value = "/api/order-sales/{id}")
    SalesOrderVO getSalesOrder(@PathVariable("id") int id);

    @GetMapping(value = "/api/order-sales/{current}/{size}")
    List<SalesOrderVO> getSalesOrders(@PathVariable("current") int current, @PathVariable("size") int size);

}
