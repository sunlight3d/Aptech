CREATE DATABASE employeedb;
USE employeedb;
CREATE TABLE IF NOT EXISTS employee (
    empno INT(3) NOT NULL,
    ename VARCHAR(40) NOT NULL,
    post VARCHAR(40) NOT NULL,
    salary bigint(10) NOT NULL
);

INSERT INTO `employee` (`empno`, `ename`, `post`, `salary`) VALUES
(1, 'George', 'Manager', 100000),
(2, 'John', 'President', 200000),
(3, 'Kevin', 'Manager', 210000),
(4, 'Tom Hanks', 'CEO', 200000),
(5, 'Rachel', 'Accounts', 100000);

ALTER TABLE employee
ADD UNIQUE (ename, post);
