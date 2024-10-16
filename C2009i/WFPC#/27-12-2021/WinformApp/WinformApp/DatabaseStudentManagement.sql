CREATE TRIGGER trigger_after_insert_tblStudent ON tblStudent
AFTER INSERT AS
BEGIN
    SET NOCOUNT ON;
    DECLARE @classId INT;
    select @classId=i.ClassId from inserted i;	
    UPDATE tblClass SET tblClass.NumberOfStudents = tblClass.NumberOfStudents + 1
    WHERE tblClass.ClassId = @classId;
END;
DROP TRIGGER trigger_after_insert_tblStudent;

drop table Students;
CREATE TABLE tblClass(
    ClassId INT PRIMARY KEY IDENTITY(1, 1),
    ClassName NVARCHAR(30) NOT NULL,
    NumberOfStudents INT NOT NULL
);
-- su dung trigger de tang dan NumberOfStudents len
INSERT INTO tblClass(ClassName, NumberOfStudents) VALUES
('C1010GV', 0),
('C10009M', 0),
('C1010KV', 0),
('C1011L', 0);

CREATE TABLE tblStudent(
    StudentId INT PRIMARY KEY IDENTITY(1, 1),
    StudentName NVARCHAR(30) NOT NULL,
    Gender BIT NOT NULL,
    DateOfBirth DATETIME NOT NULL,
    Address NVARCHAR(255) NOT NULL,
    ClassId INT  NOT NULL,
    UserName NVARCHAR(20) NOT NULL,
    Password NVARCHAR(20) NOT NULL,    
);
SELECT * FROM tblStudent;
SELECT * FROM tblClass;

ALTER TABLE tblStudent
ADD FOREIGN KEY (ClassId) REFERENCES tblClass(ClassId);

DELETE FROM tblStudent WHERE 1=1;
INSERT INTO tblStudent(StudentName, Gender, DateOfBirth, Address, ClassId, UserName,Password) VALUES
('Nguyen Van Hung', 1,'1990/09/08','Đội Cấn', 1, 'hungnv', '123456'),
('Tran Van Hieu', 1,'1990/03/15','Ba Dinh', 2, 'hieutv', '123456'),
('Le Thi Hong', 0,'1990/05/11','Hai Ba Trung', 2, 'honglt', '123456'),
('Nguyen Van Tien', 1,'1990/08/28','Hoan Kiem', 1, 'tiennv', '123456'),
('Hoang Mai Huong', 0,'1990/08/28','Xuan Dinh', 2, 'huonghm', '123456');

SELECT * FROM tblStudent;

CREATE VIEW view_StudentClass AS
SELECT tblClass.ClassName,
    tblStudent.StudentName, 
    tblStudent.UserName,
    tblStudent.Address,        
FROM tblStudent
    INNER JOIN tblClass 
ON tblStudent.ClassId=tblClass.ClassId;
