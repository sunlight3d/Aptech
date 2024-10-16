CREATE DATABASE CustomerService;
USE CustomerService;
--nvarchar = Unicode Variable Character
-- NOT NULL, DEFAULT,... is called "constraints"
DROP TABLE Employees;--only if table is "blank", otherwise => "alter table"
CREATE TABLE Employees(
	EmployeeID INT PRIMARY KEY IDENTITY(1, 1),
	FirstName NVARCHAR(100) NOT NULL,
	LastName NVARCHAR(100) NOT NULL,
	BirthDate DATETIME,
	Photo VARCHAR(50) DEFAULT '',
	Notes TEXT
);
--insert data
INSERT INTO Employees(FirstName,LastName,BirthDate,Photo, Notes) VALUES
('Davolio', 'Nancy', '1968-08-12', 'fmdsifjd.jpg',
'Education includes a BA in psychology from Colorado State University. She also completed (The Art of the Cold Call). Nancy is a member of ''Toastmasters International''');
--as => ALIAS
SELECT * FROM Employees; --* = all fields(properties)
SELECT 
	Employees.EmployeeID AS 'id Nhân Viên', 
	Employees.FirstName AS 'Họ', 
	Employees.LastName AS 'Tên Đệm'
FROM Employees;

INSERT INTO Employees(EmployeeID,LastName,BirthDate,Photo, Notes) VALUES
(2,'Leverling ', 'Janet', '1963-08-29', 'fmdsifewmejmw.jpg',
'Educatiofmdkfnmdik includes a BA in psychology from Colorado State University. She also completed (The Art of the Cold Call). Nancy is a member of ''Toastmasters International''');

DELETE FROM Employees WHERE Employees.EmployeeID=3;

