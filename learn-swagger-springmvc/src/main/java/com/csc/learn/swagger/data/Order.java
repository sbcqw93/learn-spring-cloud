package com.csc.learn.swagger.data;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created by Administrator on 2018/6/13 0013.
 */
@ApiModel(value = "Order")
public class Order {
    @ApiModelProperty(name = "orderId")
    private String orderId;
    @ApiModelProperty(name = "price")
    private String price;
    @ApiModelProperty(name = "productName")
    private String productName;

    public Order() {
    }

    public Order(String orderId, String price, String productName) {
        this.orderId = orderId;
        this.price = price;
        this.productName = productName;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Order{");
        sb.append("orderId='").append(orderId).append('\'');
        sb.append(", price='").append(price).append('\'');
        sb.append(", productName='").append(productName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
