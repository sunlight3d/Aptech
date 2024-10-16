using myapp.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace myapp.Controllers
{
    public class ProductController : Controller
    {
        // GET: Product
        public ActionResult Index()
        {
            return View(); //Views/Product/Index.cshtml
        }
        public ActionResult About()
        {
            ViewBag.product = new Product() { 
                Id = 1,
                Name = "iphone x",
                Description = "This is iphone xxx"
            };
            ViewBag.y = 2222;
            return View(); //Views/Product/About.cshtml
        }
        public EmptyResult TestAction1() { 
            return new EmptyResult();
        }
        public JsonResult TestAction2()
        {
            var products = new List<Product>() { 
                new Product() { 
                    Name = "xxx",
                    Description = "This is XX"
                },
                new Product() {
                    Name = "yyy",
                    Description = "This is yy"
                },
                new Product() {
                    Name = "zzz",
                    Description = "This is ZZ"
                }
            };
            return Json(products, JsonRequestBehavior.AllowGet);            
        }
        public JsonResult TestAction3()
        {
            var products = new List<Product>() {
                new Product() {
                    Name = "xxx",
                    Description = "This is XX"
                },
                new Product() {
                    Name = "yyy",
                    Description = "This is yy"
                },
                new Product() {
                    Name = "zzz",
                    Description = "This is ZZ"
                }
            };
            Dictionary<String, Object> result = new Dictionary<string, object>();
            result.Add("result", "ok");
            result.Add("data", products);
            result.Add("message", "Query data successfully");
            return Json(result, JsonRequestBehavior.AllowGet);
        }
        public JavaScriptResult TestAction4() {
            return JavaScript(@"const x = 123; alert('haha')");
        }
        public ContentResult TestAction5()
        {
            return Content("This is RAW string");
        }
        
    }
}