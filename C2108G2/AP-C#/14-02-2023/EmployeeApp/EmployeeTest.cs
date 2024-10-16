using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    internal class EmployeeTest
    {
        public void Test() { 
            NewEmployee newEmployee = new NewEmployee();
            newEmployee.Input();
            Console.WriteLine(newEmployee.ToString());
        }
    }
}
