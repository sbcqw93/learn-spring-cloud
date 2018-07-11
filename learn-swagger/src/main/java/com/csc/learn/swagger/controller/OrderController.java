package com.csc.learn.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.csc.learn.swagger.data.Order;
import com.csc.learn.swagger.service.OrderService;
import com.csc.learn.swagger.support.ResJson;

/**
 * Created by Lihuan on 2018/6/13 0013.
 */
@RestController
@RequestMapping(value = "order")
@Api("订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @ResponseBody
    @RequestMapping(value = "queryOrder/{orderId}", method = RequestMethod.GET)
    @ApiOperation(value = "获取订单详细信息", notes = "根据url的id来获取订单详细信息")
    @ApiImplicitParam(name = "orderId", value = "订单编号", required = true, dataType = "string", paramType = "path", defaultValue = "B1001")
    public String queryOrder(@PathVariable String orderId) {
        return ResJson.success(orderService.queryOrderById(orderId));
    }

    @ResponseBody
    @RequestMapping(value = "saveOrderByFields", method = RequestMethod.POST)
    @ApiOperation(value = "保存订单信息", notes = "保存订单信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderId", value = "订单编号", required = true, dataType = "string", paramType = "from", defaultValue = "B1001"),
            @ApiImplicitParam(name = "price", value = "订单金额", required = true, dataType = "string", paramType = "from", defaultValue = "100.00"),
            @ApiImplicitParam(name = "productName", value = "商品名称", required = true, dataType = "string", paramType = "from", defaultValue = "电脑"),
    })
    public String saveOrderByFields(@RequestParam String orderId, @RequestParam String price, @RequestParam String productName) {
        Order order = new Order(orderId, price, productName);
        return ResJson.success(orderService.saveOrder(order));
    }
}
