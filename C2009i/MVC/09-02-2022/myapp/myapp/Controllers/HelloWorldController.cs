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
        public string Index()
        {
            //return View();
            return "This is my <b>default</b> action...";
        }
        public string Welcome(string name, int id = 1)
        {
            return HttpUtility.HtmlEncode("Hello " + name + ", NumTimes is: " + id);
        }
    }
}