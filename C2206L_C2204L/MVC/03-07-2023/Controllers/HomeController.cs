using _03_07_2023.Models;
using Microsoft.AspNetCore.Mvc;
using System.Diagnostics;

namespace _03_07_2023.Controllers
{
    public class HomeController : Controller
    {
        private readonly ILogger<HomeController> _logger;

        //inject MyDBContext
        private readonly MyDBContext _dbContext; //Inject 
        public HomeController(ILogger<HomeController> logger, MyDBContext dbContext)
        {
            _logger = logger;
            _dbContext = dbContext;
        }

        public IActionResult Index()
        {
            var fakeDataGenerator = new FakeDataGenerator(_dbContext);
            fakeDataGenerator.GenerateFakeProducts(1000);
            _dbContext.Departments.Add(new Department
            {
                DepartmentName = "Sales and ...",
            });
            _dbContext.SaveChanges();//commit
            
            Console.WriteLine("haha");//business
            return View();//thư mục Views/Home/Index.cshtml
        }

        public IActionResult Privacy()
        {
            return View();
        }

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]
        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }
    }
}