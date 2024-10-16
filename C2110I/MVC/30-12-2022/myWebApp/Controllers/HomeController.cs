using Microsoft.AspNetCore.Mvc;
using myWebApp.Models;
using myWebApp.ViewModels;
using System.Diagnostics;

namespace myWebApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index(StudentViewModel studentViewModel)
        {
            //send data from controller to view?
            //ViewBag, ViewData, Model
            /*
            int x = 10;
            ViewBag.x = x;
            ViewBag.name = "Hoang";
            */
            //ViewData as Dictionary

            //ViewData["email"] = "nguyenvana@gmail.com";
            //ViewBag.studentName = studentViewModel.StudentName;
            return View(studentViewModel);//return a html file            
            //return /Views/Home/Index.cshtml
            //return Views/{ControllerName}/{MethodName in Controller}.cshtml
            //eg: Views/Product/Insert.cshtml
            
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}