using Microsoft.AspNetCore.Mvc;

namespace myWebApp.Controllers
{
    public class CalculationController : Controller
    {
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Sum() { 
            return View(); //Sum.cshtml
        }
    }
}
