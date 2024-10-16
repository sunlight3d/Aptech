using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ControllersExample.Models;
using Microsoft.AspNetCore.Mvc;


namespace ControllersExample.controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            ExampleModel model = new ExampleModel() { 
                Sentence = "Welcome to module 4 demo 1" 
            };//builder pattern
            return View(model);
            return View();//Index.cshtml
        }
    }
}
