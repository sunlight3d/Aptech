using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WorldJourney.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            ViewBag.x = 10;
            return RedirectToAction("Index", "City");
        }
    }
}
