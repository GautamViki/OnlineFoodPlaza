package com.masai.service;

import com.masai.entity.Customer;
import com.masai.entity.OrderDetails;
import com.masai.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    public OrderDetails updateOrder(OrderDetails order);

    public OrderDetails addOrder(OrderDetails order);

    public OrderDetails removeOrder(OrderDetails order);

    public OrderDetails viewOrder(OrderDetails order);

    public List<OrderDetails> viewAllOrders(Restaurant res);

    public List<OrderDetails> viewAllOrders(Customer customer);

}
