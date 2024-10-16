using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using BindViewsExample.Models;
using Microsoft.AspNetCore.Mvc;

namespace BindViewsExample.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }

        [Route("Home/Display")]
        public IActionResult AnotherWayToDisplay()
        {
            Restaurant restaurant = new Restaurant() { Id = 1, Name = "My Kitchen 1", Address = "New Brunswick, 2657 Webster Street", Speciality = "Hamburgers", Open = true, Review = 4 };
            return View(restaurant);//AnotherWayToDisplay.cshtml

        }
    }
}