package com.masai.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.entity.Bill;
import com.masai.repository.BillDao;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDao billdao;
	
	@Override
	public Bill addBill(Bill bill) {
		Bill bill1 = billdao.save(bill);
		return bill1;
	}

	@Override
	public Bill updateBill(Bill bill) {
		
		return null;
	}

	@Override
	public Bill removeBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bill viewBill(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBill(LocalDate startDate, LocalDate endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bill> viewBill(String custId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Double calculateTotalCost(Bill bill) {
		// TODO Auto-generated method stub
		return null;
	}

}
