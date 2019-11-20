package com.example.api;

import com.example.api.dto.PostSalesOrder;
import com.example.api.dto.PutSalesOrder;
import com.example.api.vo.SalesOrderVO;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(value = "order-server", fallbackFactory = SalesOrderFallBackFactory.class)
public interface SalesOrderApi {

    Integer createSalesOrder(PostSalesOrder salesOrder);

    boolean deleteSalesOrder(int id);

    Integer updateSalesOrder(PutSalesOrder salesOrder);

    SalesOrderVO getSalesOrders(int id);

    List<SalesOrderVO> getSalesOrders(int current, int size);

}
