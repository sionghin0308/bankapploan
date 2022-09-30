package com.application.bank.controller;

import java.text.ParseException;

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
import com.application.bank.services.BankerService;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/api/banker")
public class BankerRestController {
	
	@Autowired
	private BankerService bankerService;
    
	@PostMapping("/login")
    @ApiOperation(value = "Get Banker Login", notes = "Get Banker Login")
    public @ResponseBody ResponseEntity<?> getBankerLogin(@RequestBody User user)  throws RecordNotFoundException {
    	return bankerService.getBankerLogin(user);
    }
    
    @PostMapping("/createCredit")
    @ApiOperation(value = "Open New Credit", notes = "Open New Credit")
    public ResponseEntity<?> createCredit(@RequestBody CreditFacility credit) throws RecordNotFoundException, ParseException {
    	return bankerService.createCredit(credit);
    }
    
    @PostMapping("/createLoan")
    @ApiOperation(value = "Create New Loan to Applicant", notes = "Create New Loan to Applicant")
    public ResponseEntity<?> createLoan(@RequestBody Loan loan) throws RecordNotFoundException {
    	return bankerService.createLoan(loan);
    }
    
    @GetMapping("/listCredit")
    @ApiOperation(value = "Get Credit Facility List", notes = "Get Credit Facility List")
    public @ResponseBody ResponseEntity<?> getCreditFacilityList() throws RecordNotFoundException {
    	return bankerService.getCreditFacilityList();
    }
    
    @GetMapping("/listLoan")
    @ApiOperation(value = "List Loan", notes = "List Loan")
    public ResponseEntity<?> getLoanList()  throws RecordNotFoundException {
    	return bankerService.getLoanList();
    }
}
