create table tbl_books (
    B_CODE	VARCHAR2(20)		PRIMARY KEY,
    B_NAME	nVARCHAR2(125)	NOT NULL,	
    B_AUTHER	nVARCHAR2(125)	NOT NULL,	
    B_COMP	nVARCHAR2(125),		
    B_YEAR	VARCHAR2(10),		
    B_IPRICE	NUMBER		
);

create table tbl_member (
    M_ID	VARCHAR2(6)	NOT NULL	PRIMARY KEY,
    M_PASSWORD	nVARCHAR2(125)	NOT NULL,	
    M_LOGIN_DATE	nVARCHAR2(125),		
    M_REM	nVARCHAR2(125)		
);

create table tbl_read_book (
    RB_SEQ	NUMBER	NOT NULL	PRIMARY KEY,
    RB_BCODE	VARCHAR2(20)	NOT NULL,	
    RB_DATE	VARCHAR2(10)	NOT NULL,	
    RB_STIME	VARCHAR2(10),		
    RB_RTIME	NUMBER(10,3),		
    RB_SUBJECT	nVARCHAR2(20),		
    RB_TEXT	nVARCHAR2(400),		
    RB_STAR	NUMBER		
);

create SEQUENCE seq_read_book
start with 1 INCREMENT by 1;


alter table tbl_books
add CONSTRAINT fk_books
FOREIGN KEY(b_code)
REFERENCES tbl_read_book(rb_bcode);






