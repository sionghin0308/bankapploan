package com.application.bank.respository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.application.bank.model.CreditFacility;
import com.application.bank.model.Loan;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, Long> {
	List<Loan> findByCfId(long cfId);
}
