using ECommerceApp.Models;
using ECommerceApp.Utilities;
using ECommerceApp.ViewModels;
using Microsoft.AspNetCore.Mvc;
using System.Linq;
using ECommerceApp.Utilities;


namespace ECommerceApp.Controllers
{
    public class UserController : Controller
    {
        private readonly ECommerceDbContext _context;
        public UserController(ECommerceDbContext context)
        {
            _context = context;
        }

        public IActionResult Index()
        {
            _context.GenerateFakedProducts();
            return View();
        }
        [HttpGet]
        public IActionResult Login()
        {           
            return View(new UserViewModel()); //Views/User/Login.cshtml
        }

        [HttpPost]
        public IActionResult Login(UserViewModel model)
        {            
            string email = model.Email;
            string password = model.Password;
            User? selectedUser = _context.Users
                                .Where(user => user.Email.Equals(email))
                                .FirstOrDefault();
            if (selectedUser == null)
            {
                //thong bao ko tim thay user
            }
            else {
                if (Helper.EncryptPassword(password).Equals(selectedUser.Password)) { 
                    //login thanh cong
                }
            }

            return View(model);//Views/User/Login.cshtml
        }

        
        //Register
        [HttpGet]
        public IActionResult Register()
        {
            return View(new UserViewModel()); //Views/User/Register.cshtml
        }
        
        [HttpPost]
        public IActionResult Register(RegisterViewModel model)
        {
            string email = model.Email;
            string password = model.Password;
            _context.Database.EnsureCreated();
            _context.Users.Add(new User
            {
                Email = email,
                Password = Helper.EncryptPassword(password)                
            
            });
            _context.SaveChanges();
            return View(model);//Views/User/Login.cshtml
        }
    }
}
