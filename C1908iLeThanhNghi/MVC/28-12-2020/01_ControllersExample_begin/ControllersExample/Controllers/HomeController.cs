using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ControllersExample.Models;
using Microsoft.AspNetCore.Mvc;

namespace ControllersExample.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            ExampleModel model = new ExampleModel() { Sentence = "Welcome to module 4 demo 1" };
            return View(model);
        }
        public IActionResult ParamExample(string id)
        {
            return Content("My param is: " + id);
        }
        public IActionResult RouteDataExample()
        {
            string controller = (string)RouteData.Values["Controller"];
            string action = (string)RouteData.Values["action"];
            string id = (string)RouteData.Values["id"];
            return Content($"Action information: the action is in {controller} controller, the action name is {action} and the id value is {id}");
        }
        public IActionResult ViewBagExample()
        {
            ViewBag.Message = "ViewBag Example Hoang";
            return View();//ViewBagExample.cshtml
        }
        public IActionResult ViewDataExample()
        {
            ViewData["Message"] = "day la view darasss Example";
            return View();//ViewDataExample.cshtml
        }

    }
}
