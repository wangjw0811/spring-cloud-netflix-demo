package com.example.api;

import com.example.api.dto.PostSalesOrder;
import com.example.api.dto.PutSalesOrder;
import com.example.api.vo.SalesOrderVO;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class SalesOrderFallBackFactory implements FallbackFactory<SalesOrderApi> {
    @Override
    public SalesOrderApi create(Throwable throwable) {
        return new SalesOrderApi() {
            @Override
            public Integer createSalesOrder(PostSalesOrder salesOrder) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public boolean deleteSalesOrder(int id) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return false;
            }

            @Override
            public Integer updateSalesOrder(PutSalesOrder salesOrder) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public SalesOrderVO getSalesOrder(int id) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }

            @Override
            public List<SalesOrderVO> getSalesOrders(int current, int size) {
                log.error("fallback; reason was: " + throwable.getMessage());
                return null;
            }
        };
    }
}
