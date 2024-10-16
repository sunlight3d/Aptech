using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using System.Windows.Forms;
/*
CREATE DATABASE testdb;
use testdb;
CREATE TABLE tblClass(
    MaLop INT PRIMARY KEY IDENTITY(1,1),
    TenLop NVARCHAR(30) NOT NULL, 
    SiSo INT NOT NULL,
);
CREATE TABLE tblStudent(
    MaSv INT PRIMARY KEY IDENTITY(1,1),
    TenSv NVARCHAR(30) NOT NULL, 
    GioiTinh bit,
    NSinh DATETIME,
    DiaChi NVARCHAR(30) NOT NULL, 
    MaLop int,
    UserNm NVARCHAR(30),
    Password NVARCHAR(20) NOT NULL,
);
ALTER TABLE tblStudent
ADD CONSTRAINT FK_ClassStudent
FOREIGN KEY (MaLop) REFERENCES tblClass(MaLop);

INSERT into tblClass(TenLop, SiSo)
VALUES(N'C2002LDoiCan', 10);
SELECT * FROM tblClass;
SELECT * FROM tblStudent;
insert into tblStudent(MaLop, TenSv, GioiTinh, NSinh, DiaChi,UserNm, [Password])
VALUES(1, 'Nguyen Van A', 1, '1993/03/03', 'nha A, ngo B, pho C','nguyenvana', '123456');
SELECT * FROM tblStudent WHERE tblStudent.UserNm = 'nguyenvana' AND tblStudent.Password = '123456';

SELECT tblClass.TenLop, tblStudent.TenSv,tblStudent.UserNm, tblStudent.DiaChi 
FROM tblStudent
INNER JOIN tblClass ON tblStudent.MaLop=tblClass.MaLop;
 */

namespace myapp
{
    static class Program
    {
        /// <summary>
        ///  The main entry point for the application.
        /// </summary>
        [STAThread]
        static void Main()
        {
            Application.SetHighDpiMode(HighDpiMode.SystemAware);
            Application.EnableVisualStyles();
            Application.SetCompatibleTextRenderingDefault(false);
            Application.Run(new LoginForm());
        }
    }
}
