using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;

namespace StateExample.Controllers
{
    public class AnotherController : Controller
    {
        public IActionResult Index()
        {
            int? overallVisitsNumber = HttpContext.Session.GetInt32("Overall");
            int? controllerVisitsNumber = HttpContext.Session.GetInt32("Another");
            if (overallVisitsNumber == null)
            {
                overallVisitsNumber = 1;
            }
            else
            {
                overallVisitsNumber++;
            }
            if (controllerVisitsNumber == null)
            {
                controllerVisitsNumber = 1;
            }
            else
            {
                controllerVisitsNumber++;
            }
            HttpContext.Session.SetInt32("Overall", overallVisitsNumber.Value);
            HttpContext.Session.SetInt32("Another", controllerVisitsNumber.Value);

            return View();
        }
    }
}