package com.application.bank.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/web")
public class WebController {
	
	@GetMapping(value="/applicant/login")
	public ModelAndView getApplicantLoginPage(HttpServletRequest request) {
		String page = "applicantLogin";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/applicant/dashboard")
	public ModelAndView getApplicantDashboardPage(HttpServletRequest request) {
		String page = "applicantDashboard";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/banker/login")
	public ModelAndView getBankerLoginPage(HttpServletRequest request) {
		String page = "bankerLogin";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/banker/dashboard")
	public ModelAndView getBankerDashboardPage(HttpServletRequest request) {
		String page = "bankerDashboard";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/banker/createApplicant")
	public ModelAndView getBankerCreateApplicantPage(HttpServletRequest request) {
		String page = "bankerCreateApplicant";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/banker/openCreditFacility")
	public ModelAndView getBankerOpenCreditFacilityPage(HttpServletRequest request) {
		String page = "bankerOpenCreditFacility";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}
	
	@GetMapping(value="/banker/applyLoan")
	public ModelAndView getBankerApplyLoanPage(HttpServletRequest request) {
		String page = "bankerApplyLoan";
		ModelAndView mv = new ModelAndView(page);
		return mv;
	}

}
