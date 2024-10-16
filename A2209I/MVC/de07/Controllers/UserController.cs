using de07.Data;
using de07.Models;
using de07.ViewModels;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

namespace de07.Controllers
{
    public class UserController : Controller
    {        
        private readonly UserManager<ApplicationUser> _userManager;
        private readonly SignInManager<ApplicationUser> _signInManager;
        private readonly ApplicationDbContext _applicationDbContext;
        

        public UserController(
            UserManager<ApplicationUser> userManager, 
            SignInManager<ApplicationUser> signInManager,
            ApplicationDbContext applicationDbContext
            )
        {
            _userManager = userManager;
            _signInManager = signInManager;
            _applicationDbContext = applicationDbContext;
        }

        [HttpGet]        
        public async Task<IActionResult> Login()
        {
            return View(new LoginViewModel()); // Initializes a new instance for the view
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Login(LoginViewModel model)
        {            
            if (ModelState.IsValid)
            {
                var user = await _applicationDbContext.Users
                    .Where(item => item.Email.Equals(model.Email))
                    .FirstOrDefaultAsync();
                if (user != null)
                {
                    // Attempt to sign in the user
                    var result = await _signInManager.PasswordSignInAsync(user, model.Password, model.RememberMe, lockoutOnFailure: false);

                    if (result.Succeeded)
                    {
                        return RedirectToAction(nameof(ServiceController.Index), "Service");
                    }

                    if (result.IsLockedOut)
                    {
                        // If the user is locked out, handle accordingly
                        ModelState.AddModelError(string.Empty, "This account has been locked out. Please try again later.");
                    }
                    else
                    {
                        // Add error message if login attempt fails
                        ModelState.AddModelError(string.Empty, "Invalid login attempt.");
                    }
                }
                else
                {
                    ModelState.AddModelError(string.Empty, "No account found with this email address.");
                }
                              
            }

            // Nếu không thành công, hiển thị lại form
            return View(model);
        }
        [HttpGet]
        public IActionResult Register()
        {
            return View(new RegisterViewModel());  // This will return the Register view
        }
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Register(RegisterViewModel model)
        {
            if (ModelState.IsValid)
            {
                var user = new ApplicationUser
                {
                    UserName = model.Email,
                    Email = model.Email,
                    AddressHome = model.AddressHome,
                    PhoneHome = model.PhoneHome,
                    Job = model.Job
                };
                var result = await _userManager.CreateAsync(user, model.Password);
                if (result.Succeeded)
                {
                    // Optionally sign-in the user after registration
                    await _signInManager.SignInAsync(user, isPersistent: false);
                    
                    // Redirect to login or home page after successful registration
                    return RedirectToAction("Index", "Service");
                }
                foreach (var error in result.Errors)
                {
                    ModelState.AddModelError(string.Empty, error.Description);
                }
            }

            // Something failed, redisplay form
            return View(model);
        }


    }
}
