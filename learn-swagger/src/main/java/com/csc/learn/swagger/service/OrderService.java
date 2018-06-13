package com.csc.learn.swagger.service;

import com.csc.learn.swagger.data.Order;

/**
 * Created by Administrator on 2018/6/13 0013.
 */
public interface OrderService {
    public Order queryOrderById(String orderId);
    public boolean saveOrder(Order order);
}
