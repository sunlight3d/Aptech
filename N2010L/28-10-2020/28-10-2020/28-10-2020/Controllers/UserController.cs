using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using _28_10_2020.Data;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore.Internal;

namespace _28_10_2020.Controllers
{
    public class UserController : Controller
    {
        private readonly MyDBContext myDBContext;
        public UserController(MyDBContext myDBContext)
        {
            this.myDBContext = myDBContext;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult DoSomething(string name, int age) {
            //ViewData["name"] = "Hoang";//Hastable = Dictionary 
            ViewBag.name = name;
            ViewBag.age = age;            
            var firstUser = myDBContext.Users.FirstOrDefault();
            Console.WriteLine("xxx");
            return View();
        }

        private object CreateHostBuilder(object args)
        {
            throw new NotImplementedException();
        }
    }
}
