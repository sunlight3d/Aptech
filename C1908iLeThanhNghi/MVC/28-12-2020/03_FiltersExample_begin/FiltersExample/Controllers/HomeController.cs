using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using FiltersExample.Filters;
using Microsoft.AspNetCore.Mvc;

namespace FiltersExample.Controllers
{
    public class HomeController : Controller
    {
        [CustomActionFilter]
        public IActionResult Index()
        {
            return Content("Welcome to module 4 demo 3");
        }
    }
}