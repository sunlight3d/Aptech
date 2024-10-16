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