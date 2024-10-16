using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeApp
{
    public class EmployeeManagement
    {
        List<TemporaryEmp> listEmployees = new List<TemporaryEmp>();
        public void InputEmployees() {
            Console.WriteLine("Input list of employees");
            while (true) 
            {
                TemporaryEmp temporaryEmp = new TemporaryEmp();
                temporaryEmp.InputData();
                Console.WriteLine("Do you want to continue(yes, no)?");
                string answer = Console.ReadLine() ?? "no";
                if(answer.ToLower().Equals("no"))
                {
                    break;
                }
            }
            Console.WriteLine("input finished");
        }
        public void DisplayEmployees() { 
            listEmployees.ForEach(employee => employee.DisplayDetail());
        }
        public void DisplayMaxNumWork() {
            Employee employeeWithMax = listEmployees
                .OrderByDescending(employee => employee.NumWork).First();

            if (employeeWithMax != null)
            {
                listEmployees.Where(employee => employee.NumWork == employeeWithMax.NumWork)
                            .ToList()
                            .ForEach(employee => employee.DisplayDetail());
            } else {
                Console.WriteLine("cannot find");
            }
        }
        public void SeachEmployees() {
            Console.WriteLine("enter name to search");
            string name = Console.ReadLine() ?? "";
            listEmployees.Where(item => item.EmpName.Contains(name))
                .ToList()
                            .ForEach(employee => employee.DisplayDetail());


        }
    }
}
