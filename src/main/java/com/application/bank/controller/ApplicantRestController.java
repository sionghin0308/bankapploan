package com.application.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.application.bank.exception.RecordNotFoundException;
import com.application.bank.model.CreditFacility;
import com.application.bank.model.Loan;
import com.application.bank.model.User;
import com.application.bank.services.ApplicantService;
import com.application.bank.services.BankerService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/applicant")
public class ApplicantRestController {
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private BankerService bankerService;

	@PostMapping("/login")
    @ApiOperation(value = "Get Applicant Login", notes = "Get Applicant Login")
    public @ResponseBody ResponseEntity<?> getApplicantLogin(@RequestBody User user)  throws RecordNotFoundException {
    	return applicantService.getApplicantLogin(user);
    }
	
    @PostMapping("/createUser")
    @ApiOperation(value = "Create User", notes = "Create User")
    public @ResponseBody ResponseEntity<?> createUser(@RequestBody User user)  throws RecordNotFoundException {
    	return applicantService.createUser(user);
    }
    
    @GetMapping("/list")
    @ApiOperation(value = "Get Applicant List", notes = "Get Applicant List")
    public @ResponseBody ResponseEntity<?> getApplicantList()  throws RecordNotFoundException {
    	return applicantService.getApplicantList();
    }
    
    @PostMapping("/listCredit")
    @ApiOperation(value = "Get Credit Facility List", notes = "Get Credit Facility List")
    public @ResponseBody ResponseEntity<?> getCreditFacilityIndividualList(@RequestBody CreditFacility creditFacility)  throws RecordNotFoundException {
    	return bankerService.getCreditFacilityIndividualList(creditFacility);
    }
    
    @PostMapping("/listLoan")
    @ApiOperation(value = "List Loan", notes = "List Loan")
    public @ResponseBody ResponseEntity<?> getLoanIndividualList(@RequestBody Loan loan)  throws RecordNotFoundException {
    	return bankerService.getLoanIndividualList(loan);
    }
    
}
