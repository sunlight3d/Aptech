CREATE DATABASE de07;
CREATE TABLE tbl_employee(
	employee_no VARCHAR(20) PRIMARY KEY,
	employee_name VARCHAR(30) NOT NULL,
	place_of_work VARCHAR(30) DEFAULT '',
	phone_number VARCHAR(10)
);

INSERT INTO tbl_employee (employee_no, employee_name, place_of_work, phone_number) VALUES
('EMP001', 'John Doe', 'Office A', '1234567890'),
('EMP002', 'Jane Smith', 'Office B', '9876543210'),
('EMP003', 'Michael Johnson', 'Office C', '4567890123'),
('EMP004', 'Emily Davis', 'Office A', '7890123456'),
('EMP005', 'David Wilson', 'Office B', '2109876543'),
('EMP006', 'Sarah Anderson', 'Office C', '5432109876'),
('EMP007', 'Daniel Brown', 'Office A', '9012345678'),
('EMP008', 'Jessica Taylor', 'Office B', '6543210987'),
('EMP009', 'Christopher Clark', 'Office C', '2345678901'),
('EMP010', 'Olivia Rodriguez', 'Office A', '8765432109');