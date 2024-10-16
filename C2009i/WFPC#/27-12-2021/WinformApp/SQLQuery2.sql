CREATE VIEW view_StudentClass AS
SELECT tblClass.ClassName,
    tblStudent.StudentName, 
    tblStudent.UserName,
    tblStudent.Address        
FROM tblStudent
    INNER JOIN tblClass 
ON tblStudent.ClassId=tblClass.ClassId;
select * from view_StudentClass;