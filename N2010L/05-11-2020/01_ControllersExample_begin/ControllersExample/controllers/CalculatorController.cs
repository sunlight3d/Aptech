using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace ControllersExample.controllers
{
    public class CalculatorController : Controller
    {

        public IActionResult Index()
        {
            ViewBag.y = 13;
            return View();//co tra ra vie ko
        }
        //Caculator/MultByTwo/3
        public IActionResult MultByTwo(int num)
        {
            int result = num * 2;
            return Content(result.ToString());
        }
        //Calc/Mult/6/3
        [Route("Calc/Mult/{num1:int}/{num2:int}")]
        //route with typed params        
        public IActionResult Mult(int num1, int num2)
        {
            int result = num1 * num2;
            return Content($"{result}");
        }
        [HttpGet("Divide/{param?}")]
        public IActionResult DivideByTen(int param)
        {
            int result = param / 10;
            return Content(result.ToString());
        }

    }
}
