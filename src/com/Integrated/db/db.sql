CREATE TABLE TELEMEDICINE(
	TEL_SEQ NUMBER PRIMARY KEY,
	ID_U VARCHAR2(30) REFERENCES USER_TB(ID_U) NOT NULL,
	ID_D VARCHAR2(30) REFERENCES DOCTOR_TB(ID_D) NOT NULL,
	CHAT_NO NUMBER REFERENCES CHAT_LOG(CHAT_NO) NOT NULL,
	CHECKD CHAR(1) CHECK(CHECKD IN ('Y','N')) NOT NULL,
	DISEASE VARCHAR2(2000) NOT NULL,
	RESERV_DATE DATE NOT NULL
)

CREATE TABLE CLINIC(
	ID_U VARCHAR2(30) REFERENCES USER_TB(ID_U) NOT NULL,
	ID_D VARCHAR2(30) REFERENCES DOCTOR_TB(ID_D) NOT NULL,
	DISEASE VARCHAR2(2000) NOT NULL,
	RESERV_DATE DATE NOT NULL,
	CATEGORY VARCHAR2(20) NOT NULL,
	CHECKD CHAR(1) CHECK(CHECKD IN ('Y','N')) NOT NULL
)

CREATE TABLE TEL_RESULT(
	TEL_SEQ NUMBER PRIMARY KEY,
	DX_NAME VARCHAR2(200) NOT NULL,
	DX_CONTENT VARCHAR2(2000) NOT NULL,
	PURPOSE VARCHAR2(100) NOT NULL,
	REMARKS VARCHAR2(2000),
	ISS_DATE DATE NOT NULL
)

CREATE TABLE COMMENTS(
	BOARD_NO NUMBER REFERENCES BOARD_FR(BOARD_NO) NOT NULL,
	CONTENT_A VARCHAR2(200) NOT NULL,
	REGDATE_A DATE NOT NULL,
	ID_U VARCHAR2(30) REFERENCES USER_TB(ID_U) NOT NULL
)

CREATE TABLE BOARD_FR(
	BOARD_NO NUMBER PRIMARY KEY,
	ID_U VARCHAR2(30) REFERENCES USER_TB(ID_U) NOT NULL,
	TITLE VARCHAR2(50) NOT NULL,
	CONTENT VARCHAR2(2000),
	REGDATE DATE NOT NULL,
	VIEWS NUMBER NOT NULL
)

CREATE TABLE INQUIRY(
	BOARD_NO NUMBER PRIMARY KEY,
	ID_U VARCHAR2(30) REFERENCES USER_TB(ID_U) NOT NULL,
	TITLE VARCHAR2(50) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	REGDATE DATE NOT NULL,
	ANS_CHK CHAR(1) CHECK(ANS_CHK IN ('Y','N')) NOT NULL
)

CREATE TABLE NOTICE(
	NT_SEQ NUMBER PRIMARY KEY,
	ID_D VARCHAR2(30) REFERENCES DOCTOR_TB(ID_D) NOT NULL,
	TITLE VARCHAR2(50) NOT NULL,
	CONTENT VARCHAR2(2000) NOT NULL,
	REGDATE DATE NOT NULL,
	VIEWS NUMBER NOT NULL
)


CREATE TABLE DOCTOR_TB(
	ID_D VARCHAR2(30) PRIMARY KEY,
	PW_D VARCHAR2(30) NOT NULL,
	NAME_D VARCHAR2(30) NOT NULL,
	GENDER_D CHAR(1) CHECK(GENDER_D IN ('M','F')) NOT NULL,
	NUMBER_D VARCHAR2(30) NOT NULL,
	ADDR_D VARCHAR2(200) NOT NULL,
	MEDICAL_D VARCHAR2(200) NOT NULL,
	EMAIL_D VARCHAR2(50) NOT NULL,
	GRADE_D CHAR(1) CHECK(GRADE_D IN ('M','L','S','D')) NOT NULL,
	DEPARTMENT VARCHAR2(30) NOT NULL,
	ACTIVATION CHAR(1) CHECK(ACTIVATION IN ('L','D')) NOT NULL
)

CREATE TABLE USER_TB(
	ID_U VARCHAR2(30) PRIMARY KEY,
	PW_U VARCHAR2(30) NOT NULL,
	NAME_U VARCHAR2(30) NOT NULL,
	GENDER_U CHAR(1) CHECK (GENDER_U IN ('M','F')) NOT NULL,
	NUMBER_U VARCHAR2(30) NOT NULL,
	ADDR_U VARCHAR2(200) NOT NULL,
	EMAIL_U VARCHAR2(50) NOT NULL,
	ACTIVATION CHAR(1) CHECK (ACTIVATION IN ('L','D')) NOT NULL
)

CREATE TABLE CHAT_LOG(
	CHAT_NO NUMBER PRIMARY KEY,
	CHAT VARCHAR2(4000)
)
