package com.masai.service;

import org.springframework.stereotype.Service;
import com.masai.entity.OrderDetail;

@Service
public interface OrderDetailsService {
    public OrderDetail updateOrder(Integer orderId, OrderDetail order);

    public OrderDetail addOrder(OrderDetail order);

    public String removeOrder(Integer orderId);

    public OrderDetail viewOrder(Integer orderId);


}
