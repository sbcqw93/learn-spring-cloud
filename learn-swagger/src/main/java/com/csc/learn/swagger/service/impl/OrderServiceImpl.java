package com.csc.learn.swagger.service.impl;

import com.csc.learn.swagger.data.Order;
import com.csc.learn.swagger.service.OrderService;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2018/6/13 0013.
 */
@Service
public class OrderServiceImpl implements OrderService {

    private Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public Order queryOrderById(String orderId) {
        LOG.info("queryOrderById 成功, orderId={}", orderId);
        Order order = new Order(orderId, "10.00", "电脑");
        return order;
    }

    @Override
    public boolean saveOrder(Order order) {
        LOG.info("saveOrder 成功, order={}", order);
        return true;
    }
}
