package com.masai.service;

import java.util.List;
import org.springframework.stereotype.Service;

import com.masai.entity.Bill;

@Service
public interface BillService {
    public Bill addBill(Bill bill);

    public Bill updateBill(Integer id, Integer totalItem, Double totalCost);

    public Bill removeBill(Integer id);

    public Bill viewBill(Integer id);

    public List<Bill> viewBill1(Integer orderId);

    public Double calculateTotalCost(Bill bill);
}

