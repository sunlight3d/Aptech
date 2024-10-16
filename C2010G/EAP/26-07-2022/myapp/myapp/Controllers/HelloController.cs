using System;
using Microsoft.AspNetCore.Mvc;

namespace myapp.Controllers
{
    [ApiController]
    [Route("[controller]")]

    public class HelloController : ControllerBase
    {
        private readonly ILogger<HelloController> _logger;
        public HelloController(ILogger<HelloController> logger)
        {
            _logger = logger;
        }
        //apis
        [HttpGet(Name = "sayHello")]
        public String SayHello() {
            return "Hello world";
        }
    }
}

