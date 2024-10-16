using de11.Models;
using de11.ViewModels;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Primitives;

namespace de11.Controllers
{
    public class EmployeeController : Controller
    {
        private readonly DataContext context;
        public EmployeeController(DataContext context) {
            this.context = context;
        }
        public IActionResult Index()
        {
            var employees = context.Employees.ToList();
            ViewBag.Employees = employees;
            ViewBag.Employee = new Employee { };
            return View();
        }
        [HttpPost]
        public IActionResult EditEmployee(Employee employee)
        {
            Employee? existingEmployee = this.context.Employees
                                    .Where(e => e.EmployeeNo == employee.EmployeeNo)?
                                    .FirstOrDefault();
            if (existingEmployee != null)
            {
                existingEmployee.EmployeeName = string.IsNullOrEmpty(employee.EmployeeName) 
                                    ? existingEmployee.EmployeeName : employee.EmployeeName;
                existingEmployee.Position = string.IsNullOrEmpty(employee.Position)
                                    ? existingEmployee.Position : employee.Position;
                existingEmployee.Salary = employee.Salary;
                this.context.SaveChanges();
            }
            return RedirectToAction(nameof(Index));
        }
        [HttpGet]
        public IActionResult EditEmployee(int employeeNo) {
            Employee? employee = context.Employees
                                    .Where(employee => employee.EmployeeNo==employeeNo)?
                                    .FirstOrDefault();
            if (employee == null)
            {
                return RedirectToAction(nameof(Index));
            }
            return View(employee);
        }
        [HttpPost]
        public IActionResult InsertEmployee(EmployeeViewModel employeeViewModel) {
            this.context.Add(new Employee { 
                EmployeeNo = employeeViewModel.EmployeeNo,
                EmployeeName = employeeViewModel.EmployeeName,
                Position = employeeViewModel.Position,
                Salary = employeeViewModel.Salary
            });
            return RedirectToAction(nameof(Index));
        }
        [HttpGet]
        public IActionResult DeleteEmployee(int employeeNo) {
            // Delete the record
            Employee? existingEmployee = this.context.Employees?
                .Where(e => e.EmployeeNo == employeeNo)?
                .FirstOrDefault();
            if (existingEmployee != null)
            {
                context.Remove(existingEmployee);
                context.SaveChanges();
            }

            return RedirectToAction(nameof(Index));
        }

    }
}
