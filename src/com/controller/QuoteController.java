package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bean.Quote;
import com.service.QuoteService;

@Controller
public class QuoteController {

	@Autowired
	QuoteService quoteService;
	
	@RequestMapping(value = "storePolicyPage",method = RequestMethod.GET)
	public ModelAndView storePolicyPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("addPolicy.jsp");
		return mav;
	}
	
	@RequestMapping(value = "storeQuote",method = RequestMethod.POST)
	public ModelAndView storeProductDetails(HttpServletRequest req) {
		Quote quote = new Quote();
		quote.setSqft(Integer.parseInt(req.getParameter("quoteSqft")));
		quote.setYears(Integer.parseInt(req.getParameter("quoteYears")));
		quote.setCostpersqft(Integer.parseInt(req.getParameter("quoteCostpersqft")));
		quote.setPrice(Integer.parseInt(req.getParameter("quotePrice")));
		quote.setLocation(req.getParameter("location"));
		ModelAndView mav = new ModelAndView();
		String result = quoteService.storeQuoteDetails(quote);
		mav.addObject("msg", result);
		mav.setViewName("addPolicy.jsp");
		return mav;
	}
	
	@RequestMapping(value = "displayAllQuote")
	public ModelAndView getAllQuoteDetails(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		List<Quote> allQuotes = quoteService.getAllQuote();
		hs.setAttribute("allQuote", allQuotes);
		System.out.println("Display all quote");
		mav.setViewName("viewAllPolicy.jsp");
		return mav;
	}
	
	@RequestMapping(value = "displayAllQuoteToCustomer")
	public ModelAndView getAllQuoteDetailsToCustomer(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		List<Quote> allQuotes = quoteService.getAllQuote();
		hs.setAttribute("allQuoteToCustomer", allQuotes);
		mav.setViewName("displayAllQuoteToCustomer.jsp");
		return mav;
	}
	
	@RequestMapping(value = "updateQuoteView",method = RequestMethod.GET)
	public ModelAndView getToAllUpdateQuoteDetails(HttpSession hs) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updatePolicy.jsp");
		return mav;
	}
	
	@RequestMapping(value = "updateSelectedPolicy",method = RequestMethod.GET)
	public ModelAndView updateSelectedPolicy(HttpServletRequest req,HttpSession hs) {
		int qid = Integer.parseInt(req.getParameter("qid"));
		System.out.println("Quote id is "+qid);
		ModelAndView mav = new ModelAndView();
		System.out.println("Event fired...");
		Quote pp = quoteService.getQuote(qid);
		if(pp!=null) {
			hs.setAttribute("quoteInfo", pp);
			System.out.println("session variable set");
			hs.removeAttribute("pmsg");
		}else {
			hs.setAttribute("pmsg", "Quote not available");
			hs.removeAttribute("quoteInfo");
		}
		mav.setViewName("updatePolicy.jsp");
		hs.removeAttribute("quoteUpdateMsg");
		return mav;
	}
	
	@RequestMapping(value="updateQuote",method = RequestMethod.POST)
	public ModelAndView updateQuote(HttpServletRequest req,HttpSession hs) {
		Quote pro = new Quote();
		pro.setQid(Integer.parseInt(req.getParameter("qid")));
		pro.setCostpersqft(Integer.parseInt(req.getParameter("quoteCostpersqft")));
		pro.setSqft(Integer.parseInt(req.getParameter("quoteSqft")));
		pro.setPrice(Integer.parseInt(req.getParameter("quotePrice")));
		System.out.println(pro);
		ModelAndView mav = new ModelAndView();
		String result = quoteService.updateQuoteDetails(pro);
		hs.setAttribute("quoteUpdateMsg", result);
		hs.removeAttribute("quoteInfo");
		mav.setViewName("updatePolicy.jsp");
		return mav;
	}
	
}
