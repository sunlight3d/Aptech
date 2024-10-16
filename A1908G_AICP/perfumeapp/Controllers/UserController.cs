using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using perfumeapp.Models;
using perfumeapp.ViewModel;
using System.Security.Cryptography;
using System.Text;

namespace perfumeapp.Controllers
{
    public class UserController : Controller
    {
        private readonly ApplicationDbContext _context;

        public UserController(ApplicationDbContext context)
        {
            _context = context;
        }
        public IActionResult Index()
        {
            return View();
        }
        public IActionResult Register()
        {
            return View();//Register.cshml
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Register(RegisterViewModel model)
        {
            if (ModelState.IsValid)
            {
                var existingUser = await _context.Users.SingleOrDefaultAsync(u => u.Email == model.Email);
                if (existingUser == null)
                {
                    User newUser = new User
                    {
                        FirstName = model.FirstName,
                        LastName = model.LastName,
                        Email = model.Email,
                        Password = HashPassword(model.Password)
                    };

                    _context.Users.Add(newUser);
                    await _context.SaveChangesAsync();

                    // Log the user in by setting a session
                    HttpContext.Session.SetInt32("UserID", newUser.UserID);
                    HttpContext.Session.SetString("FirstName", newUser.FirstName);

                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("Email", "Email already exists.");
                }
            }
            return View(model);
        }

        public IActionResult Login()
        {
            return View();
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Login(LoginViewModel model)
        {
            if (ModelState.IsValid)
            {
                var user = await _context.Users.SingleOrDefaultAsync(u => u.Email == model.Email);

                if (user != null && VerifyPassword(model.Password, user.Password))
                {
                    HttpContext.Session.SetInt32("UserID", user.UserID);
                    HttpContext.Session.SetString("FirstName", user.FirstName);

                    if (model.RememberMe)
                    {
                        // Save user email and password hash in cookies
                        CookieOptions options = new CookieOptions
                        {
                            Expires = DateTime.Now.AddDays(30),
                            HttpOnly = true
                        };

                        Response.Cookies.Append("Email", user.Email, options);
                        Response.Cookies.Append("Password", user.Password, options);
                    }

                    return RedirectToAction("Index", "Home");
                }
                else
                {
                    ModelState.AddModelError("Login", "Invalid email or password.");
                }
            }
            return View(model);
        }

        public IActionResult Logout()
        {
            HttpContext.Session.Clear();
            Response.Cookies.Delete("Email");
            Response.Cookies.Delete("Password");
            return RedirectToAction("Index", "Home");
        }

        private string HashPassword(string password)
        {
            using (var sha256 = SHA256.Create())
            {
                var hashedBytes = sha256.ComputeHash(Encoding.UTF8.GetBytes(password));
                return BitConverter.ToString(hashedBytes).Replace("-", "").ToLower();
            }
        }

        private bool VerifyPassword(string password, string hashedPassword)
        {
            return HashPassword(password) == hashedPassword;
        }
    }
}

