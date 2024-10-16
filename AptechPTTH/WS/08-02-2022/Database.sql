CREATE DATABASE WebServiceExam;
USE WebServiceExam;
CREATE TABLE TblEmployee(
	EmployeeNo VARCHAR(20) PRIMARY KEY,
	EmployeeName VARCHAR(30) NOT NULL,
	PlaceOfWork VARCHAR(30) NOT NULL,
	PhoneNo VARCHAR(10) NOT NULL
);
INSERT INTO TblEmployee(EmployeeNo, EmployeeName, PlaceOfWork, PhoneNo)
VALUES('222', 'nguyen van xx', 'hcm', '9038998329');