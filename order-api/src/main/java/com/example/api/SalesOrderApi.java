package com.example.api;

import com.example.api.dto.PostSalesOrder;
import com.example.api.dto.PutSalesOrder;
import com.example.api.vo.SalesOrderVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "order-server", fallbackFactory = SalesOrderFallBackFactory.class, primary = false)
public interface SalesOrderApi {

    @PostMapping(value = "/order-sales")
    Integer createSalesOrder(PostSalesOrder salesOrder);

    @DeleteMapping(value = "/order-sales/{id}")
    boolean deleteSalesOrder(@PathVariable("id") int id);

    @PutMapping(value = "/order-sales")
    Integer updateSalesOrder(PutSalesOrder salesOrder);

    @GetMapping(value = "/order-sales/{id}")
    SalesOrderVO getSalesOrder(@PathVariable("id") int id);

    @GetMapping(value = "/order-sales/{current}/{size}")
    List<SalesOrderVO> getSalesOrders(@PathVariable("current") int current, @PathVariable("size") int size);

}
