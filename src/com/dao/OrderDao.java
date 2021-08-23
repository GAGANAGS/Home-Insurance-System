package com.dao;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Customer;
import com.bean.Login;
import com.bean.Orders;
import com.bean.Quote;
import com.utility.Items;

@Repository
public class OrderDao {

	@Autowired
	EntityManagerFactory emf;
	
	public int placeOrder(String quotes,String email, int totalAmount) {
		
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
			
			Customer cc = manager.find(Customer.class, email);
			cc.setAmount(totalAmount - cc.getAmount());
			Orders or = new Orders();
			or.setEmail(email);
			or.setOrderDate(Date.valueOf(LocalDate.now()));
			or.setProductName(quotes);
			or.setPrice(totalAmount);
			tran.begin();
				manager.persist(or);
				manager.merge(cc);
			tran.commit();
		return 1;
	}
	
	public List<Orders> getOrderDetails(String email){
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select o from Orders o where o.email=?1");
		qry.setParameter(1, email);
		return qry.getResultList();
	}
	
	public float getBalanceAmount(String email) {
		EntityManager manager = emf.createEntityManager();
		Customer cc = manager.find(Customer.class, email);
		return cc.getAmount();
	}
	
	
}