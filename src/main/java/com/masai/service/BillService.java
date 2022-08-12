package com.masai.service;

import com.masai.entity.Bill;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

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
