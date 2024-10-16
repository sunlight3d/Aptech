using Microsoft.AspNetCore.Mvc;

namespace bai01.Controllers
{
    public class CalculationController : Controller
    {
        [HttpGet]
        public IActionResult Sum()
        {
            return View();//render view named Sum.cshtml
        }

        [HttpPost]
        public IActionResult DoSum(int x, int y)
        {            
            // Truyền result về view Sum và hiển thị kết quả
            ViewBag.sum = x + y;
            return View("Sum");
        }
    }
}
