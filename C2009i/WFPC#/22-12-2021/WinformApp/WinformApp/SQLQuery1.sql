drop table Students;
CREATE TABLE Students(
    StudentId INT PRIMARY KEY IDENTITY(1, 1),
    StudentName NVARCHAR(100),
    UserName NVARCHAR(100),
    Password NVARCHAR(50),
    Address NVARCHAR(300),
);
INSERT INTO Students(StudentName, UserName, Password, Address) VALUES
('Nguyen Van A', 'hoangnd', '123456', 'adress aa aa11'),
('Nguyen Van B', 'nguyendana', 'jduisduy483', 'adress aa 3i928u34'),
('Nguyen Van C', 'nvb', 'dskjd', 'adress aa 888'),
('Nguyen Van D', 'nguyenvanc', 'jdifhjdu', 'adress aa a33');
SELECT * FROM Students;