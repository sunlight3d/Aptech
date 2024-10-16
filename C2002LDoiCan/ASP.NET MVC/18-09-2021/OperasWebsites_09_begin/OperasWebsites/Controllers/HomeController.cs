using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace OperasWebsites.Controllers
{
    public class HomeController : Controller
    {
        
        // GET: Home
        public ActionResult Index()
        {

            Console.WriteLine("haha");
            return View("Index");
        }

        public ActionResult About()
        {
            return View("");
        }
    }
}