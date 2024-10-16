using System;
using System.Collections.Generic;
namespace Exam3
{
    class Program
    {
        static void Main(string[] args)
        {
            EmployeeManagement employeeManagement = new EmployeeManagement();
            /*
            
            employeeManagement.SearchEmployee();
            employeeManagement.DisplayEmployees();
            */
            employeeManagement.InputEmployee();
            /*
            employeeManagement.ListEmployee = new List<TemporaryEmp> {  
                new TemporaryEmp() { 
                    EmpID = 11,
                    EmpName = "Nguyen Van A",
                    DOB = new DateTime(1989,12,25),
                    Department = "IT",
                    NumWork = 2,
                    WorkDay = 10,
                },
                new TemporaryEmp() {
                    EmpID = 11,
                    EmpName = "Nguyen Van B",
                    DOB = new DateTime(1989,25,12),
                    Department = "ACB",
                    NumWork = 3,
                    WorkDay = 20,
                }
            };
            */
            employeeManagement.SearchEmployee();
            employeeManagement.DisplayEmployees();
        }
    }
}
