USE StudentManagement;
DROP TABLE Person;
CREATE TABLE Person(
	PersonId INT PRIMARY KEY IDENTITY(1, 1),
	FirstName NVARCHAR(30) NOT NULL,
	LastName NVARCHAR(30) NOT NULL
);
INSERT INTO Person(FirstName, LastName) VALUES
('Nguyen Van', 'A'),
('Nguyen Xuan', 'X'),
('Tran Van', 'C'),
('Pham Van', 'B');

SELECT 
	Person.PersonId as 'Số thứ tự',
	Person.FirstName as 'Họ',
	Person.LastName AS 'Tên', 	
	CONCAT(Person.FirstName, ' ', Person.LastName) as 'Tên đầy đủ'
FROM Person;
--calculated values
DROP TABLE tblStudent;
CREATE TABLE tblStudent(
	StudentId INT PRIMARY KEY IDENTITY(1, 2),
	Math INT DEFAULT 0, 
	Physics INT DEFAULT 0,
	Chemistry INT DEFAULT 0,
);
INSERT INTO tblStudent(Math, Physics, Chemistry) VALUES
(4,5,6),
(5,9,2),
(6,7,8);
INSERT INTO tblStudent(Math, Chemistry)
VALUES(5,6);

SELECT 
	StudentId AS 'Số thứ tự', 
	Math AS 'Điểm Toán', 
	Physics AS 'Điểm Lý', 
	Chemistry AS 'Điểm hóa',
	Math+Physics+Chemistry AS 'Tổng điểm',
	(Math+Physics+Chemistry)/3.0 AS 'Trung bình'
FROM tblStudent;

SELECT * FROM tblStudent;

