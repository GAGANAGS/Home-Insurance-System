package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bean.Quote;

@Repository
public class QuoteDao {

	
	@Autowired
	EntityManagerFactory emf;
	
	public int storeQuote(Quote pr) {

		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		tran.begin();
		manager.persist(pr);
		tran.commit();

		Quote p = manager.find(Quote.class, pr.getQid());
		if (p != null) {
			return 1;
		} else {
			return 0;
		}

	}

	public List<Quote> getAllQuote() {
		EntityManager manager = emf.createEntityManager();
		Query qry = manager.createQuery("select p from Quote p");
		return qry.getResultList();
	}

	public Quote getQuoteById(int qid) {
		EntityManager manager = emf.createEntityManager();
		Quote p = manager.find(Quote.class, qid);
		if (p != null) {
			System.out.println("qid found, returning details");
			return p;
		} else {
			return null;
		}
	}

	public int updateQuoteDetails(Quote pr) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();

		Quote p = manager.find(Quote.class, pr.getQid());
		if (p != null) {
			tran.begin();
			p.setCostpersqft(pr.getCostpersqft());
			p.setSqft(pr.getSqft());
			p.setPrice(pr.getPrice());
			manager.merge(p);
			tran.commit();
			return 1;
		} else {
			return 0;
		}
	}

	/*public int reducerQuantity(int pid, int quantity) {
		EntityManager manager = emf.createEntityManager();
		EntityTransaction tran = manager.getTransaction();
		Product p = manager.find(Product.class, pid);
		if (p.getProductQuantity() >= quantity) {
			tran.begin();
			p.setProductQuantity(p.getProductQuantity() - quantity);
			manager.merge(p);
			tran.commit();
			return 1;
		} else {
			return 0;
		}

	}*/
}

