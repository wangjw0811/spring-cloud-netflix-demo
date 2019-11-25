package com.example.orderserver.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.api.SalesOrderApi;
import com.example.api.dto.PostSalesOrder;
import com.example.api.dto.PostSalesOrderDetail;
import com.example.api.dto.PutSalesOrder;
import com.example.api.vo.SalesOrderVO;
import com.example.orderserver.entity.OrderSales;
import com.example.orderserver.entity.OrderSalesDetail;
import com.example.orderserver.mapper.OrderSalesMapper;
import com.example.orderserver.service.IOrderSalesDetailService;
import com.example.orderserver.service.IOrderSalesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import utils.exception.ServerException;

import java.util.List;

/**
 * <p>
 * 销售订单表 服务实现类
 * </p>
 *
 * @author Jims Wang
 * @since 2019-11-19
 */
@Slf4j
@Service
public class OrderSalesServiceImpl extends ServiceImpl<OrderSalesMapper, OrderSales> implements IOrderSalesService,SalesOrderApi {
    @Autowired
    OrderSalesMapper orderSalesMapper;

    @Autowired
    private IOrderSalesDetailService orderSalesDetailService;

    @Override
    @Transactional
    public Integer createSalesOrder(PostSalesOrder salesOrder) {
        OrderSales orderSales = new OrderSales();
        PostSalesOrder postSalesOrder = new PostSalesOrder();
        // 获取单号
        String orderNo = "2019112001";
        orderSales.setOrderNo(orderNo);
        BeanUtils.copyProperties(salesOrder, postSalesOrder);
        boolean ok = this.save(orderSales);
        if(!ok){
            log.error("订单创建异常");
            throw new ServerException("订单创建异常");
        }
        Integer id = orderSales.getId();
        List<PostSalesOrderDetail> details = salesOrder.getDetails();
        try{
            details.forEach(detail->{
                OrderSalesDetail orderSalesDetail = new OrderSalesDetail();
                BeanUtils.copyProperties(orderSalesDetail, detail);
                orderSalesDetail.setOrderId(id);
                orderSalesDetailService.save(orderSalesDetail);
            });
        }catch (Exception e){
            throw new ServerException("订单明细保存异常");
        }
        return null;
    }

    @Override
    public boolean deleteSalesOrder(int id) {
        return this.removeById(id);
    }

    @Override
    public Integer updateSalesOrder(PutSalesOrder salesOrder) {
//        OrderSales orderSales = new OrderSales();
//        BeanUtils.copyProperties(salesOrder, orderSales);
//        this.updateById()
        return null;
    }

    @Override
    public SalesOrderVO getSalesOrder(int id) {
        OrderSales orderSales = this.getById(id);
        if(orderSales == null){
            return null;
        }
        SalesOrderVO vo = new SalesOrderVO();
        BeanUtils.copyProperties(orderSales,vo);
        return vo;
    }

    @Override
    public List<SalesOrderVO> getSalesOrders(int current, int size) {
        Page<SalesOrderVO> salesOrder = this.getSalesOrdersWithDetails(current, size);
        return salesOrder.getRecords();
    }

    @Override
    public Page<SalesOrderVO> getSalesOrdersWithDetails(int current, int size) {
        Page page = new Page(current,size);
        Page<SalesOrderVO> vos = orderSalesMapper.getSalesOrdersWithDetails(page);
        return vos;
    }

    @Override
    public SalesOrderVO getSalesOrderWithDetails(int id) {
        SalesOrderVO salesOrderWithDetails = orderSalesMapper.getSalesOrderWithDetails(id);

        return salesOrderWithDetails;
    }
}
