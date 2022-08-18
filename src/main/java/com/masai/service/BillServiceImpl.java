package com.masai.service;


import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masai.entity.Bill;
import com.masai.entity.Customer;
import com.masai.repository.BillDao;
import com.masai.repository.CustomerDao;

@Service
public class BillServiceImpl implements BillService {
	
	@Autowired
	private BillDao billdao;
	@Autowired
	private CustomerDao cdao;
	@Override
	public Bill addBill(Bill bill) {
		Bill bill1 = billdao.save(bill);
		return bill1;
	}

	@Override
	public Bill updateBill(Integer id, Integer totalItem, Double totalCost) {
		Optional<Bill> bill = billdao.findById(id);
		Bill bill1 = bill.get();
		bill1.setTotalItem(totalItem);
		bill1.setTotalCost(totalCost);
		return billdao.save(bill1);
	}

	@Override
	public Bill removeBill(Integer id) {
		Optional<Bill> bill = billdao.findById(id);
		Bill bill1 = bill.get();
		billdao.delete(bill1);
		return bill1;
	}

	@Override
	public Bill viewBill(Integer id) {
		Optional<Bill> opt = billdao.findById(id);
       	Bill bill = opt.get();
		return bill;
	}

	@Override
	public Double calculateTotalCost(Bill bill) {
		
		return null;
	}

	@Override
	public List<Bill> viewBill1(Integer custId) {
		Optional<Customer> opt = cdao.findById(custId);
	
		return null;
	}


	
}
