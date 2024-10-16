CREATE DATABASE de07;
USE de07;
CREATE TABLE Student(
	rollnumber INT PRIMARY KEY AUTO_INCREMENT,
	name VARCHAR(80) NOT NULL,
	email VARCHAR(100) NOT NULL,
	age INT DEFAULT 18
);
INSERT INTO Student(name, email, age) VALUES
('nva', 'nnds@gmail.com', 18),
('dmsijw', 'kjdoisjd@gmail.com', 19),
('nejwhd', 'meiwjie@gmail.com', 20);