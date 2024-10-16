CREATE DATABASE C2309GDoiCan;
USE C2309GDoiCan;
CREATE TABLE employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL,
    dept_id INT, 
    age INT check(age > 18),
    sex VARCHAR(6)
);
CREATE TABLE department(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL
);

ALTER TABLE employee
ADD FOREIGN KEY (dept_id) REFERENCES department(id);

--insert 1, then insert N, in a 1-N relationship
INSERT INTO department(name) VALUES
('Sales'),
('IT'),
('Marketing');

INSERT INTO employee(name, dept_id, age,  sex) VALUES
('Nguyen AVan A', 2, 20, 'male'),
('Alan', 1, 22, 'female'),
('Nick', 3, 25, 'male');