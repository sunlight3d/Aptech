using Microsoft.AspNetCore.Mvc;
using myapp.Models;
using myapp.ViewModels;

namespace myapp.Controllers
{
    public class EmployeeController : Controller
    {
        private readonly MyDbContext _context;
        public EmployeeController(MyDbContext context)
        {
            _context = context;
        }

        [HttpGet]
        public IActionResult Index()
        {
            var employees = _context.Employees.ToList();
            return View();//danh sach cac employees
        }
        [HttpGet]
        public IActionResult AddEmployee()
        {
            return View();//Views/Employee/AddEmployee.cshtml
        }
        [HttpPost]
        public IActionResult AddEmployee(AddEmployeeViewModel viewModel)
        {

            if (ModelState.IsValid) {
                _context.Employees.Add(new Employee
                {
                    //Id = viewModel.EmployeeNo,
                    Name = viewModel.EmployeeName,
                    DepartmentId = viewModel.DepartmentId,
                    Age = viewModel.Age,
                    Sex = viewModel.Sex,
                });
                _context.SaveChanges();
                return RedirectToAction(nameof(Index));
            }
            return View();//Views/Employee/AddEmployee.cshtml
        }
    }
}
