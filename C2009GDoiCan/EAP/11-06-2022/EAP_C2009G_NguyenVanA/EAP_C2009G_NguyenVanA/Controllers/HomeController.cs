using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace EAP_C2009G_NguyenVanA.Controllers
{
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View(); //Home/Index.cshtml
        }

        public ActionResult About()
        {
            ViewBag.Message = "Your application description page.";
            //data from controller to view
            return View();//Home/About.cshtml
        }

        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }
    }
}