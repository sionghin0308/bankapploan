package com.application.bank.respository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.application.bank.model.CreditFacility;
import com.application.bank.model.User;

@Repository
public interface CreditFacilityRepository extends PagingAndSortingRepository<CreditFacility, Long> {
	List<CreditFacility> findByUserId(long userId);
}
