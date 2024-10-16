CREATE DATABASE C1908GLeThanhNghi;
USE C1908GLeThanhNghi;
CREATE TABLE Employees(
	EmployeeID INT PRIMARY KEY IDENTITY(1,1),
	EmployeeName NVARCHAR(400) NOT NULL,
	DepartmentID INT,
	Gender SMALLINT,
	BirthDate DATETIME NOT NULL,
	Telephone NVARCHAR(400),
	Address TEXT
);
INSERT INTO Employees(EmployeeName, DepartmentID,Gender,BirthDate, Telephone, Address)
VALUES(N'mr A', 1, 1, '12/11/1990','0112233',N'Nha A, ngo B, pho C');
DELETE FROM Employees WHERE 1=1;
CREATE TABLE Departments(
	DepartmentID INT PRIMARY KEY IDENTITY(1,1),
	DepartmentName NVARCHAR(400) NOT NULL	
);

ALTER TABLE Employees
ADD CONSTRAINT FK_DepartmentEmployee
FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID);

ALTER TABLE Employees 
DROP CONSTRAINT IF EXISTS FK_DepartmentEmployee;