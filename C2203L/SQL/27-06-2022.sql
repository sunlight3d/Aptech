CREATE DATABASE HumanResourceManagement;
USE HumanResourceManagement;

CREATE TABLE tblEmployee(
	firstName NVARCHAR(100), --unicode variable character, max length = 100
	lastName NVARCHAR(50),
	age INT
);
--insert data
INSERT INTO tblEmployee(firstName, lastName, age) VALUES
('nguiyen', 'van a', 18),
('alex', 'dsnmjkdjns', 18),
('aaaa', 'jowhn', 18);

INSERT INTO tblEmployee(firstName, lastName, age) VALUES
('dhsuhdfs', 'djnsjhfud', 20);

SELECT * FROM tblEmployee;

--CustomerID	CustomerName	ContactName	Address	City	PostalCode	Country

DROP TABLE Customers;
CREATE TABLE Customers(
	CustomerID INT IDENTITY(1, 1),
	CustomerName NVARCHAR(200),
	Address NVARCHAR,
	City NVARCHAR(30),
	PostalCode VARCHAR(50),
	Country NVARCHAR(60)
);
--SELECT * FROM Customers LIMIT 10 OFFSET 10; --mysql
