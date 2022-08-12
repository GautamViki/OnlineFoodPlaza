package com.masai.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
@Entity
public class OrderDetails {
    @Id
    private Integer orderId;
    private LocalDateTime order;
    private FoodCart cart;
    private String orderStatus;

    public OrderDetails(Integer orderId, LocalDateTime order, FoodCart cart, String orderStatus) {
        this.orderId = orderId;
        this.order = order;
        this.cart = cart;
        this.orderStatus = orderStatus;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public LocalDateTime getOrder() {
        return order;
    }

    public void setOrder(LocalDateTime order) {
        this.order = order;
    }

    public FoodCart getCart() {
        return cart;
    }

    public void setCart(FoodCart cart) {
        this.cart = cart;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "orderId=" + orderId +
                ", order=" + order +
                ", cart=" + cart +
                ", orderStatus='" + orderStatus + '\'' +
                '}';
    }
}
