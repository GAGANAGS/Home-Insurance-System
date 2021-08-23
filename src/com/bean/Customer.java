package com.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class Customer {
	
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String city;
	@Id
	private String email;
	private String password;
	private int accnumber;
	private int amount;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAccnumber() {
		return accnumber;
	}
	public void setAccnumber(int accnumber) {
		this.accnumber = accnumber;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender + ", dob=" + dob
				+ ", city=" + city + ", email=" + email + ", password=" + password + ", accnumber=" + accnumber
				+ ", amount=" + amount + "]";
	}
	
	
}