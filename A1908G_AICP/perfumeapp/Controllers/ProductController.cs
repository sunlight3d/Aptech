using Microsoft.AspNetCore.Mvc;

namespace perfumeapp.Controllers
{
    public class ProductController : Controller
    {
        
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Filter()
        {
            return View();
        }
    }
}
