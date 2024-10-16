using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WAD_C2002L_NguyenVanA.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            //Views/Home/Index.cshtml
            ViewBag.x = 123;
            ViewData["y"] = 456;
            return View();
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";

            return View();
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}