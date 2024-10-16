using Microsoft.AspNetCore.Mvc;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace WorldJourney.Controllers
{
    public class TravelerController : Controller
    {
        public IActionResult Index(string name)
        {
            ViewBag.VisiterName = name;
            return View();//Views/Traveler/Index.cshtml
        }
    }
}
