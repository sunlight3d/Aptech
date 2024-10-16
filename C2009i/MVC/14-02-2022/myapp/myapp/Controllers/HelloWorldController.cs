using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace myapp.Controllers
{
    public class HelloWorldController : Controller
    {
        // GET: HelloWorld
        public ActionResult Index()
        {
            return View();//Views/HelloWorld/Index.cshtml
            //return "This is my <b>default</b> action...";
        }
        public ActionResult Welcome(string name, int id = 1)
        {
            //return HttpUtility.HtmlEncode("Hello " + name + ", NumTimes is: " + id);
            ViewBag.Message = $"Hello {name}";
            ViewBag.NumberOfTimes = id;
            return View();//Views/HelloWorld/Welcome.cshtml
        }
    }
}