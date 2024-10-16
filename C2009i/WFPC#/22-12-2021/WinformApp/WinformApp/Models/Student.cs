using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

/*
CREATE TABLE Students(
    StudentId INT PRIMARY KEY IDENTITY(1, 1),
    StudentName NVARCHAR(100),
    UserName NVARCHAR(100),
    Password NVARCHAR(50),
    Address NVARCHAR(300),
);
INSERT INTO Students(UserName, Password)
VALUES('hoangnd', '123456');
 */

namespace WinformApp.Models
{
    public class Student
    {
        public int StudentId { get; set; }
        public String ClassName { get; set; }
        public String StudentName { get; set; }
        public String UserName { get; set; }
        public String Password { get; set; }
        public String Address { get; set; }
    }
}
