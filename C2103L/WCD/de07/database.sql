USE c2103l;
CREATE TABLE TblEmployee(
	EmployeeNo VARCHAR(20) PRIMARY KEY,
	EmployeeName VARCHAR(30) NOT NULL,
	PlaceOfWork VARCHAR(30) NOT NULL,
	PhoneNo VARCHAR(10)
);

-- Tạo 10 bản ghi giả mạo
INSERT INTO TblEmployee (EmployeeNo, EmployeeName, PlaceOfWork, PhoneNo)
VALUES
('EMP001', 'John Doe', 'Office A', '1234567890'),
('EMP002', 'Jane Smith', 'Office B', '9876543210'),
('EMP003', 'Michael Johnson', 'Office A', '4567890123'),
('EMP004', 'Emily Davis', 'Office C', '7890123456'),
('EMP005', 'David Wilson', 'Office B', '3210987654'),
('EMP006', 'Sarah Anderson', 'Office A', '0123456789'),
('EMP007', 'Matthew Thompson', 'Office C', '5678901234'),
('EMP008', 'Olivia Martinez', 'Office A', '8901234567'),
('EMP009', 'William Taylor', 'Office B', '2345678901'),
('EMP010', 'Sophia Garcia', 'Office C', '6789012345');