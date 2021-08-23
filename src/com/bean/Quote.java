package com.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int qid;
	private int sqft;
	private int years;
	private int costpersqft;
	private int price;
	private String location;
	public int getQid() {
		return qid;
	}
	public void setQid(int qid) {
		this.qid = qid;
	}
	public int getSqft() {
		return sqft;
	}
	public void setSqft(int sqft) {
		this.sqft = sqft;
	}
	public int getYears() {
		return years;
	}
	public void setYears(int years) {
		this.years = years;
	}
	public int getCostpersqft() {
		return costpersqft;
	}
	public void setCostpersqft(int costpersqft) {
		this.costpersqft = costpersqft;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "Quote [qid=" + qid + ", sqft=" + sqft + ", years=" + years + ", costpersqft=" + costpersqft + ", price="
				+ price + ", location=" + location + "]";
	}
	
	

}
