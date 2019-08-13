package com.lh.mapper;

import com.lh.po.Orders;
import com.lh.po.OrdersEx;

import java.util.List;

public interface OrdersMapper {
    public List<OrdersEx> queryOrderToUser() throws Exception;
    public List<Orders> queryOrderByUser() throws Exception;
    public List<Orders> queryOrderToOrderDetail() throws Exception;
    public List<Orders> queryOrderToItems() throws Exception;
}
