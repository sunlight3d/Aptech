using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
/*
 Cong ty ban yeu cau: viet ung dung C#, ket noi SQL Server 2019 va 2017
1. pull 2 image sql server 2019 va sql server 2017(pull tu windows, Linux, MacOS)
docker pull mcr.microsoft.com/mssql/server:2017-CU24-ubuntu-16.04
docker pull mcr.microsoft.com/mssql/server:2019-CU11-ubuntu-20.04
2. start 2 container sql server 2019 va sql server 2017(> 500Mb RAM)
docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Abc123456789" --name sql-server-2017-c2002l -p 1444:1433 -d mcr.microsoft.com/mssql/server:2017-CU24-ubuntu-16.04
docker run -e "ACCEPT_EULA=Y" -e "SA_PASSWORD=Abc123456789" --name sql-server-2019-c2002l -p 1445:1433 -d mcr.microsoft.com/mssql/server:2019-CU11-ubuntu-20.04

3.Connect vao 2 sql instance tren dung lenh:
sqlcmd -S tcp:127.0.0.1,1444 –U sa –P Abc123456789
select name from sys.databases;
SELECT * FROM databaseName.INFORMATION_SCHEMA.TABLES WHERE TABLE_TYPE = 'BASE TABLE';

neu du lieu tren container => db bi xoa => map thu muc db voi thu muc cua laptop(host)
 */
namespace _26_06_2021
{
    public class Test
    {
        public delegate void MyDelegate(string name);
        public void RunAllTest() {
            BookList bookList = new BookList();
            bookList.InputList();
            bookList.ShowList();
            Book firstBook = bookList.Books[0];
            Console.WriteLine($"chapter 0 of book 0 = {firstBook[0]}");
            firstBook[1] = "C++ basics";

        }
        public void MethodA(string name) {
            Console.WriteLine($"Hello {name}");
            Console.WriteLine($"Hello {name}");
        }
        public void TestDelegate() {
            //MyDelegate myDelegate = (name) => Console.WriteLine($"Hello {name}");
            MyDelegate myDelegate = this.MethodA; 
            myDelegate("Hoang");//function pointer in C/C++
            //myDelegate("John");
        }
    }
}
