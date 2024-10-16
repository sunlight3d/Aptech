using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using myapp.Models;
using myapp.ViewModels;

namespace myapp.Controllers
{
    public class UserController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.Title = "This is data from controller";
            ViewBag.X = 123;
            ViewBag.Klasses = new List<Klass>() {
                new Klass { 
                    ID = 1, Name = "C2203L", StartDate = DateTime.Parse("2023-04-15"),
                },
                new Klass {
                    ID = 2, Name = "C2009I",StartDate = DateTime.Parse("2023-05-22"),
                },
                new Klass
                {
                    ID = 3, Name = "A1908G",StartDate = DateTime.Parse("2024-06-22"),
                }
            };
            Student studentA = new Student
            {
                ID = 22,
                Name = "Nguyen Duc Hoang",
                DOB = DateOnly.Parse("1993-12-22")
            };
            return View(studentA);//Views/Index.cshtml
        }
        [HttpGet]
        public IActionResult Login() {
            LoginViewModel viewModel = new LoginViewModel
            {
                UserName = Request.Cookies["UserName"] ?? "",
                Password = Request.Cookies["Password"] ?? "",
                RememberPassword = true
            };
            return View(viewModel);//Views/Login.cshtml
        }
        [HttpGet]
        public IActionResult Register()
        {
            RegisterViewModel viewModel = new RegisterViewModel
            {
                UserName = "",
                Password = "",
                RetypePassword = "",
            };
            return View(viewModel);//Views/Login.cshtml
        }
        [HttpPost]
        public IActionResult Login(LoginViewModel viewModel)
        {

            // handle form submission
            //if success, show all classes 
            if (ModelState.IsValid) {
                if (viewModel.RememberPassword == true) {
                    Response.Cookies.Append("UserName", viewModel.UserName);
                    Response.Cookies.Append("Password", viewModel.Password);
                }
                return RedirectToAction(nameof(ShowKlasses));
            }
            return View(viewModel);
            
        }
        [HttpPost]
        public IActionResult Register(RegisterViewModel viewModel)
        {

            // handle form submission
            //if success, show all classes 
            if (ModelState.IsValid)
            {
                return RedirectToAction(nameof(ShowKlasses));
            }
            return View(viewModel);

        }

        [HttpGet]
        public IActionResult ShowKlasses() {
            return View();//Views/ShowKlasses.cshtml
        }
    }
}
