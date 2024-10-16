USE StudentManagement;
DROP TABLE Students;
--postgres, mysq
CREATE TABLE Students(
	StudentId INT PRIMARY KEY IDENTITY(1, 2),
	StudentName NVARCHAR(100),
	DateOfBirth DateTime,
	Email VARCHAR(100) DEFAULT '' 
);
INSERT INTO Students(StudentName, DateOfBirth, Email) VALUES
('Nguyen Van A', '1997/12/20', 'nguyevnanva@gmail.com'),
('Nguyen Van B', '2000/08/10', 'jjerfekre@gmail.com'),
('Nguyen Van C', '1995/05/15', 'j43nfdf@gmail.com');
SELECT * FROM Students;
UPDATE Students SET DateOfBirth='2001/08/08'
WHERE StudentId = 3;
--Xoa 'Nguyen Van B'
DELETE FROM Students WHERE StudentId=3;
INSERT INTO Students(StudentName, DateOfBirth, Email) VALUES
('Nguyen Van B', '2000/08/10', 'jjerfekre@gmail.com');
UPDATE Students SET StudentId=3 WHERE StudentId=7; 