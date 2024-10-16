using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace IdentityExample.Controllers
{
    public class StudentController : Controller
    {
        public IActionResult Index()
        {
            if (!this.User.Identity.IsAuthenticated) //not signed in
            {
                return RedirectToAction("Login", "Account"); //Action "Account", Controller "Login"
            }
            return View();
        }
    }
}