package com.controller;

import java.sql.Date;
import java.time.LocalDate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Customer;
import com.service.CustomerService;

@Controller
public class CustomerController {

	
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(value="customerSignUp",method = RequestMethod.GET)
	public ModelAndView signUpCustomer() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerSignUp.jsp");
		return mav;
	}
	
	@RequestMapping(value="customerDashboard",method = RequestMethod.GET)
	public ModelAndView customerDashboard() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("customerHome.jsp");
		return mav;
	}
	
	@RequestMapping(value="balanceCheck/{email}",method = RequestMethod.GET)
	public ModelAndView balaceCheck(@PathVariable("email") String email,HttpSession session) {
		ModelAndView mav = new ModelAndView();
		float amount = customerService.getBalanceDetails(email);
		session.setAttribute("amount", amount);
		mav.setViewName("redirect:/addAmount.jsp");
		return mav;
	}
	
	
	@RequestMapping(value="addAmount",method = RequestMethod.POST)
	public ModelAndView addAmount(HttpServletRequest req, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		String email = (String)session.getAttribute("user");
		int newAmount = Integer.parseInt(req.getParameter("amount"));
		String addAmountMsg = customerService.addAmount(email, newAmount);
		int amount = (int) customerService.getBalanceDetails(email);
		session.setAttribute("amount", amount);
		session.setAttribute("amountAddMsg", addAmountMsg);
		mav.setViewName("redirect:/addAmount.jsp");
		return mav;
	}
	
	@RequestMapping(value="customerCreate",method = RequestMethod.POST)
	public ModelAndView customerAccountCreate(HttpServletRequest req,HttpSession hs) {
		System.out.println("In customer created");
		ModelAndView mav = new ModelAndView();
		Customer cc = new Customer();
		System.out.println(req.getParameter("dob"));
		cc.setFirstName(req.getParameter("firstName"));
		cc.setLastName(req.getParameter("lastName"));
		cc.setGender(req.getParameter("gender"));
		System.out.println("1");
		cc.setDob(Date.valueOf(req.getParameter("dob")));
		System.out.println("2");
		cc.setCity(req.getParameter("city"));
		cc.setEmail(req.getParameter("email"));
		cc.setPassword(req.getParameter("password"));
		String result = customerService.storeCustomerDetails(cc);
		if(result.equals("success")) {
			mav.addObject("msg", "Account Created successfully");
		}else {
			mav.addObject("msg", "Account didn't create");
		}
		mav.setViewName("customerSignUp.jsp");
		return mav;
	}
	
	
}
