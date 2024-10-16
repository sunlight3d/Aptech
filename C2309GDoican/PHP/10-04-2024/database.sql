
CREATE DATABASE C2309GDoiCan;
USE C2309GDoiCan;
CREATE TABLE employees (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(40) NOT NULL,
    position VARCHAR(40) NOT NULL,
    salary BIGINT CHECK (salary >= 0)
);
INSERT INTO employees (id, name, position, salary) VALUES
(1, 'George', 'Manager', 100000),
(2, 'John', 'President', 200000),
(3, 'Kevin', 'Manager', 210000),
(4, 'Tom Hanks', 'CEO', 200000),
(5, 'Rachel', 'Accounts', 100000);