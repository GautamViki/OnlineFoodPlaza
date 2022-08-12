package com.masai.service;

import com.masai.entity.Customer;
import com.masai.entity.OrderDetails;
import com.masai.entity.Restaurant;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OderDetailsServiceImpl implements OrderDetailsService {
    @Override
    public OrderDetails updateOrder(OrderDetails order) {
        return null;
    }

    @Override
    public OrderDetails addOrder(OrderDetails order) {
        return null;
    }

    @Override
    public OrderDetails removeOrder(OrderDetails order) {
        return null;
    }

    @Override
    public OrderDetails viewOrder(OrderDetails order) {
        return null;
    }

    @Override
    public List<OrderDetails> viewAllOrders(Restaurant res) {
        return null;
    }

    @Override
    public List<OrderDetails> viewAllOrders(Customer customer) {
        return null;
    }
}
