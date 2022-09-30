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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

/**
 * The persistent class for the tbl_credit_facility database table.
 * 
 */
@Entity
@Table(name="tbl_credit_facility")
@Getter
@Setter
public class CreditFacility implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cf_id")
	private long cfId;

	@Column(name="total_limit")
	private BigDecimal totalLimit;
	
	@Column(name="currency")
	private String currency;
	
	@Column(name="start_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date startDate;
	
	@Column(name="end_date")
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date endDate;
	
	@Column(name="total_limit_each")
	private BigDecimal totalLimitEach;
	
	@Column(name="user_id")
	private long userId;

}
