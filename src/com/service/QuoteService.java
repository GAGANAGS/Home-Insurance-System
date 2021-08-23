package com.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.Quote;
import com.dao.QuoteDao;
//import com.utility.Items;

@Service
public class QuoteService {

	@Autowired
	QuoteDao quoteDao;
	
	public String storeQuoteDetails(Quote pr) {
	
		if(quoteDao.storeQuote(pr)>0) {
			return "Quote Details stored successfully";
		}else {
			return "Quote Details didn't store successfully";
		}
	}
	
	public List<Quote> getAllQuote(){
		return quoteDao.getAllQuote();
	}
	
	public Quote getQuote(int qid) {
		return quoteDao.getQuoteById(qid);
	}
	
	public String updateQuoteDetails(Quote pro) {
		if(quoteDao.updateQuoteDetails(pro)>0) {
			return "Product Updated successfully";
		}else {
			return "Product didn't update";
		}
	}
	
	/*public String reduceQuantity(List<Items> items) {
		for(Items ii:items){
			Product p = ii.getProduct();
			int quantity = ii.getQuantity();
			int result = productDao.reducerQuantity(p.getPid(), quantity);
			if(result==1) {
				return "success";
			}else {
				return "failure";
			}
		}
		return "done";
	}*/
}
