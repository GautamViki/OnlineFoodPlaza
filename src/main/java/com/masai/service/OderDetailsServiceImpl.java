package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.OrderDetail;
import com.masai.repository.BillDao;
import com.masai.repository.FoodcartDao;
import com.masai.repository.OrderDetailDao;

@Service
public class OderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	private FoodcartDao foodcartDao;
	@Autowired
	private BillDao billdao;
	@Autowired
	private OrderDetailDao orderDao;
	
	@Override
	public OrderDetail updateOrder(Integer orderId, OrderDetail order) {
		Optional<OrderDetail> opt = orderDao.findById(orderId);
		order.setOrderId(orderId);
		orderDao.save(order);
		return order;
	}

	@Override
	public OrderDetail addOrder(OrderDetail order) {
		foodcartDao.save(order.getCart());
		billdao.save(order.getBill());
		orderDao.save(order);
		return order;
	}

	@Override
	public String removeOrder(Integer orderId) {
		orderDao.deleteById(orderId);
		return "Deleted";
	}

	@Override
	public OrderDetail viewOrder(Integer orderId) {
		Optional<OrderDetail> opt = orderDao.findById(orderId);
		return opt.get();
	}

	@Override
	public List<OrderDetail> viewAllOrder() {
		List<OrderDetail> allOrders=orderDao.findAll();
		return null;
	}

}
