using Microsoft.AspNetCore.Mvc;
using myWebApp.Models;
using myWebApp.ViewModels;
using System;
using System.Diagnostics;
using System.Diagnostics.Metrics;

namespace myWebApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult DayOfTheWeek(String? day)
        {
            String message = "";

            if ((day ?? "").ToLower().Equals("monday")) {
                message = "Laugh on Monday, kiss a stranger";
            } else if ((day ?? "").ToLower().Equals("tuesday"))
            {
                message = "Laugh on Tuesday, kiss a stranger.";
            }
            else if ((day ?? "").Trim().ToLower().Equals("wednesday"))
            {
                message = "Laugh on Wednesday, laugh for a letter.";
            }
            else if ((day ?? "").Trim().ToLower().Equals("thursday"))
            {
                message = "Laugh on Thursday, something better.";
            }
            else if ((day ?? "").Trim().ToLower().Equals("friday"))
            {
                message = "Laugh on Friday, laugh for sorrow";
            }
            else if ((day ?? "").Trim().ToLower().Equals("saturday"))
            {
                message = "Laugh on Saturday, joy tomorrow.Laugh on Monday, laugh for danger";
            }
            ViewBag.message = message;            
            return View("DayOfTheWeek");//Views/Home/DayOfTheWeek.cshtml
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

        public IActionResult ChangeTextColor(String? message) {
            ViewBag.Message = message ?? "Nothing";
            return View("ColorText");
        }
        public IActionResult Privacy()
        {
            return View();//Views/Home/Privacy.cshtml
        }
        
        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}