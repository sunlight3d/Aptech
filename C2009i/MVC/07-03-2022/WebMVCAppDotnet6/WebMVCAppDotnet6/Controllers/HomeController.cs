using Microsoft.AspNetCore.Mvc;

namespace WebMVCAppDotnet6.Controllers
{
    public class HomeController : Controller
    {
        //Dependency Injection
        /*
        public HomeController(Logger<HomeController> logger) { 
        }
        */
        public IActionResult Index()
        {
            return View();
        }
    }
}
