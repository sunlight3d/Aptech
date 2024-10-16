CREATE DATABASE testDB;
USE testDB;
DROP TABLE tblPerson;
CREATE TABLE tblPerson(
	PersonID INT IDENTITY(1, 1),	
	Address NVARCHAR(100) NOT NULL DEFAULT '',
	MovieRented NVARCHAR(120) DEFAULT '',
	Salutation NVARCHAR(10) DEFAULT 'Mr',
	Age INT DEFAULT 18
		CHECK(Age >= 18 AND Age <= 90)
);
--FullName is missing, how to add without drop table ?
--=> alter table add column + sql server
ALTER TABLE tblPerson
ADD FullName NVARCHAR(70) NOT NULL;

ALTER TABLE tblPerson
ADD CONSTRAINT PK_Person PRIMARY KEY (PersonID, Address,FullName);

ALTER TABLE tblPerson DROP CONSTRAINT PK_Person;
--composite key = (PersonID, Address,FullName)

SELECT PersonID, Salutation, FullName, Address, MovieRented, Age FROM tblPerson
ORDER BY FullName;

DELETE FROM tblPerson; --danger !!
--sql injection

INSERT INTO tblPerson(FullName,Address, MovieRented, Salutation, Age) VALUES
(N'Nguyễn Văn XX', N'Thôn a, xã b, Hùng Cường','Star wars', 'mrs', 90),
(N'Nguyễn Văn YY', N'dsdsThôn a, xã b, Hùng Cường','Star wardds', 'mrs', 90),
(N'Nguyễn Văn ZZ', N'Thôndsd d a, xã b, Hùng Cường','Star waddrs', 'mr', 19)
;
--composite key constraint + sql server
INSERT INTO tblPerson(FullName,Address, MovieRented, Salutation, Age) VALUES
(N'Nguyễn Văn XX', N'Thôn a, xã b, Hùng Cường','Star wars', 'mrs', 90);

--1 - N relationship
--1 Department has N Employee
CREATE TABLE tblDepartment(
	DepartmentId INT PRIMARY KEY IDENTITY(1, 1),
	DepartmentName NVARCHAR(50),
	Description NVARCHAR(100)
);
INSERT INTO tblDepartment(DepartmentName, Description) VALUES
(N'Phòng Sales', 'This is sales department'),
(N'Mua bán', 'jdsij This is sales department'),
(N'Marketing', 'Thi fdijfijf s is sales department');

SELECT * FROM tblDepartment;
CREATE TABLE tblEmployee(
	EmployeeId INT PRIMARY KEY IDENTITY(1, 1),
	EmployeeName NVARCHAR(60) NOT NULL,
	DateOfBirth DateTime,
	DepartmentId INT, --foreign key
);
--constraint foreign key
ALTER TABLE tblEmployee
ADD CONSTRAINT FK_DepartmentEmployee
FOREIGN KEY (DepartmentId) REFERENCES tblDepartment(DepartmentId); 

ALTER TABLE tblEmployee
DROP CONSTRAINT FK_DepartmentEmployee;

SELECT * FROM tblEmployee;

INSERT INTO tblEmployee(EmployeeName, DateOfBirth, DepartmentId) VALUES
(N'Nguyễn Văn Cường', '1997/12/30', 3);

INSERT INTO tblEmployee(EmployeeName, DateOfBirth, DepartmentId) VALUES
(N'Nguyễn Văn Cường', '1997/12/30', 4);
