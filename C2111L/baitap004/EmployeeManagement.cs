using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace baitap004
{
    public class EmployeeManagement
    {
        public static void Main(string[] args)
        {
            string answer = "y";
            List<Employee> employees = new List<Employee>();
            while (answer.Trim().ToLower().Equals("y")) {
                Employee employee = new TemporaryEmp(0);
                employee.Input();
                employees.Add(employee);
                foreach(Employee item in employees) { 
                    item.DisplayDetail();
                }
                int maxNumberOfWorkings = employees.Max(e1 => e1.NumberOfWorkings);                
                employees
                    .Where(e => e.NumberOfWorkings == maxNumberOfWorkings)
                    .ToList()
                    .ForEach(item => item.DisplayDetail());
                Console.WriteLine("Enter name to search");                
                string searchName = (Console.ReadLine() ?? "").ToLower();
                employees.Where(e => e.EmployeeName.ToLower().Contains(searchName))
                    .ToList()
                    .ForEach(item => item.DisplayDetail());
                Console.WriteLine("do you want to continue(y/n) ? ");
                answer = Console.ReadLine() ?? "y";
                if (answer.Trim().ToLower().Equals("n")) {
                    break;
                }
            }
            Console.WriteLine("program ended");
        }
        
    }
}
