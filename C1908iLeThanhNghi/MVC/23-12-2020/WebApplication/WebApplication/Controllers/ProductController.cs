using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace WebApplication.Controllers
{
    public class ProductController : Controller
    {
        // GET: Product
        public ActionResult Index()
        {
            ViewBag.ProductPrices = new Dictionary<string, int>();
            ViewBag.ProductPrices.Add("Bread", 5);
            ViewBag.ProductPrices.Add("Rice", 3);
            return View();
        }
    }
}