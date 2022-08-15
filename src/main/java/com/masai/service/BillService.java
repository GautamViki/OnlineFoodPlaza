package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.masai.entity.Bill;

@Service
public interface BillService {
    public Bill addBill(Bill bill);

    public Bill updateBill(Bill bill);

    public Bill removeBill(Bill bill);

    public Bill viewBill(Bill bill);

    public List<Bill> viewBill(LocalDate startDate, LocalDate endDate);

    public List<Bill> viewBill(String custId);

    public Double calculateTotalCost(Bill bill);
}

