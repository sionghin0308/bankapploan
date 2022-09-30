package com.application.bank.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.application.bank.api.RestTemplate;
import com.application.bank.exception.RecordNotFoundException;
import com.application.bank.model.User;
import com.application.bank.respository.UserRepository;

@Service
public class ApplicantService extends RestTemplate {

    @Autowired
    UserRepository userRepository;

    public ResponseEntity<?> getApplicantLogin(User user) throws RecordNotFoundException  {
    	User result = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
         
    	if(result != null) {
            if(result.getUserRole() == 2 && result.getUserRole() != 0 && result.getUsername() != null) {
                return buildSuccessResponse(true, "applicant", result);
            }
    	} else {
    		return buildFailedResponse(false, "No user found or invalid password!");
    	}
		return null;
    }
    
    public ResponseEntity<?> createUser(User user) throws RecordNotFoundException {
    	user.setUsername(user.getUsername());
    	user.setPassword(user.getPassword());
    	user.setUserRole(2);
    	user.setName(user.getName());
    	user.setGender(user.getGender());
    	user.setPhone(user.getPhone());
    	user.setEmail(user.getEmail());
    	user.setAddress(user.getAddress());
    	user = userRepository.save(user);
        
        return buildSuccessResponse(true, "applicant", user);
    }
    
    public ResponseEntity<?> getApplicantList() throws RecordNotFoundException  {
    	List<User> result = userRepository.findByUserRole(2);
         
    	if(!CollectionUtils.isEmpty(result)) {
        	return buildSuccessResponse(true, "applicant", result);
        } else {
        	return buildFailedResponse(false, "Applicant List is empty!");
        }
    }
    
    // Show total loan 
    
    // Show loan transaction
    
    // Make payment
    
}
