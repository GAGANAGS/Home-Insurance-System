package com.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Customer;
import com.dao.CustomerDao;

@Service
public class CustomerService {

	@Autowired
	CustomerDao customerDao;
	
	public String storeCustomerDetails(Customer cc) {
		cc.setAmount(1000);
		if(customerDao.storeCustomerDetails(cc)>0) {
			return "success";
		}else {
			return "failure";
		}
	}
	
	public float getBalanceDetails(String email) {
		return customerDao.getBalanceDetails(email);
	}
	
	public String addAmount(String email, int amount) {
		if(customerDao.addAmount(email, amount)>0) {
			return "Amount Added successfully";
		}else {
			return "Amount didn't add";
		}
	}
}
