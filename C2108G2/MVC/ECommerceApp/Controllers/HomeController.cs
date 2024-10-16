using ECommerceApp.Models;
using ECommerceApp.ViewModels;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace ECommerceApp.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        public IActionResult Index()
        {
            ViewData["Message"] = "This is data from view data";
            ViewBag.x = 100;
            Book book = new Book
            {
                ID = 1,
                Title = "How to make money",
                Description = "This is a bestseller book",
                Price= 12.4f
            };
            List<Book> books = new List<Book> { 
                new Book { ID = 2, Title="book 2", Description = "bbb 22", Price = 22.3f},
                new Book { ID = 3, Title="book 3", Description = "bbb 333", Price = 90.8f},
                new Book { ID = 4, Title="book 4", Description = "bbb 4444", Price = 11.22f},
            };
            return View(new UserViewModel()); //Views/Home/Index.cshtml
        }
        [HttpPost]
        public IActionResult SubmitForm(UserViewModel model)
        {

            // perform action with submitted data
            if (!ModelState.IsValid) {
                return RedirectToAction("Error");
            }
            return RedirectToAction("Index");
        }
        public IActionResult Error()
        {
            var errorViewModel = new ErrorViewModel
            {
                RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier
            };
            return View(errorViewModel);
        }
    }
}