using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            ViewBag.MyName = "Hoang";
            ViewBag.x = 1;
            ViewBag.y = 2;
            ViewData["name"] = "xyzzzz";
            return View();//Index.cshtml
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();//About.cshtml
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}