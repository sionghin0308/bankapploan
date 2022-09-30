package com.application.bank.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.application.bank.api.RestTemplate;
import com.application.bank.exception.RecordNotFoundException;
import com.application.bank.model.CreditFacility;
import com.application.bank.model.Loan;
import com.application.bank.model.User;
import com.application.bank.respository.CreditFacilityRepository;
import com.application.bank.respository.LoanRepository;
import com.application.bank.respository.UserRepository;

@Service
public class BankerService extends RestTemplate {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    CreditFacilityRepository creditFacilityRepository;
    
    @Autowired
    LoanRepository loanRepository;

    public ResponseEntity<?> getBankerLogin(User user) throws RecordNotFoundException  {
    	User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
         
    	if(result != null) {
            if(result.getUserRole() == 1 && result.getUserRole() != 0 && result.getUsername() != null) {
                return buildSuccessResponse(true, "banker", result);
            }
    	} else {
    		return buildFailedResponse(false, "No user found or invalid password!");
    	}
		return null;
    }
    
    public ResponseEntity<?> createCredit(CreditFacility credit) throws RecordNotFoundException, ParseException {
    	credit.setTotalLimit(credit.getTotalLimit());
    	credit.setCurrency(credit.getCurrency());
    	credit.setStartDate(credit.getStartDate());
    	credit.setEndDate(credit.getEndDate());
    	credit.setTotalLimitEach(credit.getTotalLimitEach());
    	credit.setUserId(credit.getUserId());
    	credit = creditFacilityRepository.save(credit);
        
        return buildSuccessResponse(true, "credit facility", credit);
    }
    
    public ResponseEntity<?> createLoan(Loan loan) throws RecordNotFoundException {
    	loan.setTotalAmount(loan.getTotalAmount());
    	loan.setRemainAmount(loan.getRemainAmount());
    	loan.setCurrency(loan.getCurrency());
    	loan.setStartDate(loan.getStartDate());
    	loan.setEndDate(loan.getEndDate());
    	loan.setInterest(loan.getInterest());
    	loan.setCfId(loan.getCfId());
    	loan.setLoanType(loan.getLoanType());
    	loan = loanRepository.save(loan);
        
        return buildSuccessResponse(true, "loan", loan);
    }
    
    public ResponseEntity<?> getCreditFacilityList() throws RecordNotFoundException  {
    	Iterable<CreditFacility> result = creditFacilityRepository.findAll();
    	List<CreditFacility> list = new ArrayList<>();
    	result.forEach((p) -> {
    		list.add(p);
        });
    	
    	if(!CollectionUtils.isEmpty(list)) {
        	return buildSuccessResponse(true, "creditFacility", result);
        } else {
        	return buildFailedResponse(false, "Credit Facility List is empty!");
        }
    }
    
    public ResponseEntity<?> getLoanList() throws RecordNotFoundException  {
    	Iterable<Loan> result = loanRepository.findAll();
    	List<Loan> list = new ArrayList<>();
    	result.forEach((p) -> {
    		list.add(p);
        });
    	if(!CollectionUtils.isEmpty(list)) {
        	return buildSuccessResponse(true, "loan", list);
        } else {
        	return buildFailedResponse(false, "Loan List is empty!");
        }
    }
    
    public ResponseEntity<?> getCreditFacilityIndividualList(CreditFacility creditFacility) throws RecordNotFoundException  {
    	Iterable<CreditFacility> result = creditFacilityRepository.findByUserId(creditFacility.getUserId());
    	List<CreditFacility> list = new ArrayList<>();
    	result.forEach((p) -> {
    		list.add(p);
        });
    	
    	if(!CollectionUtils.isEmpty(list)) {
        	return buildSuccessResponse(true, "creditFacility", result);
        } else {
        	return buildFailedResponse(false, "Credit Facility List is empty!");
        }
    }
    
    public ResponseEntity<?> getLoanIndividualList(Loan loan) throws RecordNotFoundException  {
    	Iterable<Loan> result = loanRepository.findByCfId(loan.getCfId());
    	List<Loan> list = new ArrayList<>();
    	result.forEach((p) -> {
    		list.add(p);
        });
    	if(!CollectionUtils.isEmpty(list)) {
        	return buildSuccessResponse(true, "loan", list);
        } else {
        	return buildFailedResponse(false, "Loan List is empty!");
        }
    }
    
}
