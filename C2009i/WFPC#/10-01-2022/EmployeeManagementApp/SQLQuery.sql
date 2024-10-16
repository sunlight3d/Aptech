SELECT 
	Employees.EmployeeID as EmployeeID, 
	Employees.EmployeeName as EmployeeName, 
	Departments.DeptName as Department,
	case Employees.Gender when 0 then 'False' else 'True' end as Gender,	
	FORMAT(Employees.BirthDate, 'MM/dd/yyyy') as BirthDate,
	Employees.Tel as Tel,
	Employees.Address as Address
FROM Employees
INNER JOIN Departments ON Employees.DeptID = Departments.DeptID
WHERE Employees.DeptID = 'ADM';


SELECT * FROM Departments;
SELECT * FROM Employees;

INSERT INTO Employees(EmployeeName, DeptID, Gender, BirthDate, Tel, Address)
VALUES(N'Nguyen Van A', 'DTY', 1, '1993/12/25', '021122233', 'nha A ngo B');

