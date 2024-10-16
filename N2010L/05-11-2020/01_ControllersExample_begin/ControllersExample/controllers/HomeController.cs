using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using ControllersExample.Filters;
using ControllersExample.Models;
using Microsoft.AspNetCore.Mvc;


namespace ControllersExample.controllers
{
    public class HomeController : Controller
    {
        [CustomActionFilter]
        public IActionResult Index()
        {
            ExampleModel exampleModel = new ExampleModel() { 
                Sentence = "Welcome to module 4 demo 1"
            };//builder pattern
            return View(exampleModel);//truyen doi tuong tu controller xuong view            
        }
        public IActionResult ParamExample(string id)
        {
            return Content($"My param is: {id}");//view tai cho, plain text
        }        
        public IActionResult RouteDataExample()
        {
            string controller = (string)RouteData.Values["Controller"];
            string action = (string)RouteData.Values["action"];
            string id = (string)RouteData.Values["id"];
            return Content($"Action information: the action is in " +
                $"{controller} controller, the action name is {action} and the id value is {id}");
        }
        public IActionResult ViewBagExample()
        {
            ViewBag.Message = "ViewBag heeheeheh";//object.property
            ViewBag.x = 10;
            return View();
        }
        public IActionResult ViewDataExample()
        {
            ViewData["Message"] = "ViewData Example";//Dictionary
            return View();
        }

        [Route("Hello/{firstName}/{lastName}")] //bo qua controller's name        
        //Eg: http://localhost:65396/Hello/nguyenduc/hoang
        public IActionResult Greeting(string firstName, string lastName)
        {
            return Content($"Hello {firstName} {lastName} from module 4 demo 2");
        }


    }
}
