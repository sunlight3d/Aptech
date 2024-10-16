USE C2203L;
CREATE TABLE Employee(
	employeeNo INT PRIMARY KEY IDENTITY(1, 1),
	employeeName NVARCHAR(100) NOT NULL,
	position NVARCHAR(50) NOT NULL,
	salary INT NOT NULL,
);
INSERT INTO Employee (employeeName, position, salary) VALUES ('John Doe', 'Manager', 80000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Jane Smith', 'Assistant Manager', 60000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Mike Johnson', 'Team Leader', 50000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Sarah Williams', 'HR Manager', 75000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('David Lee', 'IT Manager', 85000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Karen Chen', 'Marketing Manager', 80000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Tom Brown', 'Sales Representative', 40000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Alex Rodriguez', 'Financial Analyst', 55000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Emily Wilson', 'Product Manager', 90000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Jason Davis', 'Customer Service Representative', 35000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Linda Nguyen', 'Accountant', 60000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Eric Smith', 'Software Engineer', 75000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Kim Lee', 'Graphic Designer', 45000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Sam Brown', 'Project Manager', 80000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Stephanie Taylor', 'Operations Manager', 85000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Ryan Chen', 'Sales Manager', 90000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Jessica Kim', 'Event Coordinator', 50000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Tyler Johnson', 'Web Developer', 70000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('Maria Rodriguez', 'Customer Support Manager', 75000);
INSERT INTO Employee (employeeName, position, salary) VALUES ('William Davis', 'Marketing Coordinator', 45000);
