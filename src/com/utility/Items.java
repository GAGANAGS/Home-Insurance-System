package com.utility;

import com.bean.Quote;

public class Items {
	
	private Quote quote=new  Quote();
	
	private int quantity;

	public Quote getQuote() {
		return quote;
	}

	public void setQuote(Quote quote) {
		this.quote = quote;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Items(Quote quote) {
		super();
		this.quote = quote;
		//this.quantity = quantity;
	}

	public Items() {
		super();
	}

	@Override
	public String toString() {
		return "Items [quote=" + quote + "]";
	}
	
	

}