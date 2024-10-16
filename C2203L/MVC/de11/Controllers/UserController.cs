using de11.Models;
using de11.ViewModels;
using Microsoft.AspNetCore.Mvc;


namespace de11.Controllers
{
    public class UserController : Controller
    {
        private readonly DataContext context;
        public UserController(DataContext context)
        {
            this.context = context;
        }
        public IActionResult Index()
        {
            return View();
        }
        [HttpGet]
        public IActionResult Login() { 
            LoginViewModel loginViewModel = new LoginViewModel { 
                Email = "",
                Password = ""
            };
            return View(loginViewModel);
        }
        [HttpPost]
        public IActionResult Login(LoginViewModel loginViewModel)
        {
            ViewBag.ErrorMessage = "";
            User? user = context.Users
                        .Where(user => user.Email.Equals(loginViewModel.Email ?? ""))
                        .FirstOrDefault();
            if (user == null) {
                ViewBag.ErrorMessage = "User does not exists";
                return View(loginViewModel);
            }            
            if (de11.Models.User.isMachedPassword(loginViewModel.Password, user.Password))
            {
                return RedirectToAction("Index", "Employee");
            }
            else
            {
                ViewBag.ErrorMessage = "Wrong email or password";
                return View(loginViewModel);
            }

        }

        [HttpGet]
        public IActionResult Register()
        {
            RegisterViewModel registerViewModel = new RegisterViewModel
            {
                Email = "",
                Password = "",
                RetypePassword = "",
                UserName= "",
            };
            
            return View(registerViewModel);
        }

        [HttpPost]
        public IActionResult Register(RegisterViewModel registerViewModel)
        {
            if (ModelState.IsValid)
            {
                //insert to DB
                context.Users.Add(new de11.Models.User
                { 
                    UserName = registerViewModel.UserName,
                    Password = de11.Models.User.ConvertToSha1(registerViewModel.Password),
                    Email = registerViewModel.Email,
                });
                context.SaveChanges();
                return RedirectToAction("Login", "User");
            }
            //error, show in UI
            return View(registerViewModel);
        }


        
        public IActionResult InputName(string name)
        {
            ViewBag.Name = name ?? "";
            string[] arrayOfWords = ViewBag.Name.Split(new char[] { ' ' },
                                    StringSplitOptions.RemoveEmptyEntries);
            ViewBag.ColorText = "";
            foreach (var word in arrayOfWords)
            {
                var newWord = $"<span style=\"color:red;\">" + word[0] 
                    + "</span>" + word.Substring(1);
                ViewBag.ColorText = ViewBag.ColorText + newWord + " ";
            }

            return View();
        }
        public IActionResult ShowDetailDay(string day = "")
        {
            string message = "";
            
            if (day.ToLower().Equals("monday")) {
                message = "Laugh on Monday, laugh for danger";
            } else if (day.ToLower().Equals("tuesday"))
            {
                message = "Laugh on Tuesday, kiss a stranger.";
            }
            else if (day.ToLower().Equals("wednesday"))
            {
                message = "Laugh on Wednesday, laugh for a letter.";
            }
            else if (day.ToLower().Equals("thursday"))
            {
                message = "Laugh on Thursday, something better.";
            }
            else if (day.ToLower().Equals("friday"))
            {
                message = "Laugh on Friday, laugh for sorrow.";
            }
            else if (day.ToLower().Equals("saturday"))
            {
                message = "Laugh on Saturday, joy tomorrow.";
            }
            ViewBag.Message = message;
            return View();
        }
        
    }
}
