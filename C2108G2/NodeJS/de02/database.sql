mysql -u root -P 3306 -p
CREATE DATABASE c2108g2;
use c2108g2;
CREATE TABLE employees(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100) NOT NULL,
    Age INT,
    Address VARCHAR(500) DEFAULT '',
    Salary DECIMAL(18, 1) DEFAULT 0
);
ALTER TABLE employees ADD CONSTRAINT UN_Employees_Name UNIQUE (Name);
DELETE FROM employees WHERE 1<2;
INSERT INTO employees(Name, Age, Address, Salary)
VALUES
    ('John Smith', 35, '123 Main St, Anytown USA', 50000.0),
    ('Mary Johnson', 28, '456 Oak Ave, Springfield USA', 60000.0),
    ('Michael Davis', 42, '789 Elm St, Anytown USA', 75000.0),
    ('Jessica Lee', 31, '321 Pine St, Springfield USA', 55000.0),
    ('Christopher Brown', 39, '555 Maple Dr, Anytown USA', 80000.0),
    ('Elizabeth Wilson', 26, '888 Oak Ave, Springfield USA', 45000.0),
    ('David Garcia', 48, '777 Pine St, Anytown USA', 90000.0),
    ('Sarah Martinez', 29, '222 Maple Dr, Springfield USA', 55000.0),
    ('Daniel Anderson', 36, '444 Main St, Anytown USA', 65000.0),
    ('Linda Thomas', 27, '333 Oak Ave, Springfield USA', 50000.0),
    ('James Hernandez', 43, '666 Elm St, Anytown USA', 75000.0),
    ('Emily Jackson', 32, '999 Pine St, Springfield USA', 60000.0),
    ('Joshua Wright', 40, '111 Maple Dr, Anytown USA', 80000.0),
    ('Amanda King', 25, '777 Oak Ave, Springfield USA', 45000.0),
    ('Kevin Baker', 49, '222 Pine St, Anytown USA', 90000.0),
    ('Ashley Gonzalez', 30, '444 Maple Dr, Springfield USA', 55000.0),
    ('Robert Nelson', 37, '555 Main St, Anytown USA', 65000.0),
    ('Megan White', 28, '777 Oak Ave, Springfield USA', 50000.0),
    ('William Scott', 44, '666 Elm St, Anytown USA', 75000.0),
    ('Stephanie Adams', 33, '999 Pine St, Springfield USA', 60000.0);
