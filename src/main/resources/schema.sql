CREATE SEQUENCE user_id_seq;
CREATE TABLE tbl_user (
	user_id INT NOT NULL DEFAULT nextval('user_id_seq') PRIMARY KEY,
	username VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	user_role INT,
	name VARCHAR(255),
	gender VARCHAR(6),
	phone VARCHAR(10),
	email VARCHAR(255),
	address VARCHAR(255),
);
ALTER SEQUENCE user_id_seq
OWNED BY tbl_user.user_id;

CREATE SEQUENCE cf_id_seq;
CREATE TABLE tbl_credit_facility(
	cf_id INT NOT NULL DEFAULT nextval('cf_id_seq') PRIMARY KEY,
	total_limit NUMERIC,
	currency VARCHAR(10),
	start_date DATE,
	end_date DATE,
	total_limit_each NUMERIC,
	user_id INT,
	CONSTRAINT fk_user
		FOREIGN KEY(user_id) 
		REFERENCES tbl_user(user_id)
);
ALTER SEQUENCE cf_id_seq
OWNED BY tbl_credit_facility.cf_id;

CREATE SEQUENCE loan_id_seq;
CREATE TABLE tbl_loan(
	loan_id INT NOT NULL DEFAULT nextval('loan_id_seq') PRIMARY KEY,
	total_amount NUMERIC,
	remain_amount NUMERIC,
	currency VARCHAR(10),
	start_date DATE,
	end_date DATE,
	interest NUMERIC,
	cf_id INT,
	loan_type VARCHAR(255),
	CONSTRAINT fk_credit_facility
		FOREIGN KEY(cf_id) 
		REFERENCES tbl_credit_facility(cf_id)	
);
ALTER SEQUENCE loan_id_seq
OWNED BY tbl_loan.loan_id;

CREATE SEQUENCE loan_tranx_id_seq;
CREATE TABLE tbl_loan_tranx(
	loan_tranx_id INT NOT NULL DEFAULT nextval('loan_tranx_id_seq') PRIMARY KEY,
	amount NUMERIC,
	payment_date DATE,
	loan_id INT,
	CONSTRAINT fk_loan_tranx
		FOREIGN KEY(loan_id) 
		REFERENCES tbl_loan(loan_id)	
);
ALTER SEQUENCE loan_tranx_id_seq
OWNED BY tbl_loan_tranx.loan_tranx_id;