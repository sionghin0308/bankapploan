package com.application.bank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the tbl_loan_tranx database table.
 * 
 */
@Entity
@Table(name="tbl_loan_tranx")
@Getter
@Setter
public class LoanTransaction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="loan_tranx_id")
	private long loanTranxId;

	@Column(name="amount")
	private BigDecimal amount;
	
	@Column(name="payment_date")
	private Date paymentDate;
	
	@Column(name="loan_id")
	private long loanId;

}
