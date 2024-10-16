using Azure.Core;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.AspNetCore.Mvc.Controllers;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using WebApiApp.Models;
using WebApiApp.RequestModels;
using WebApiApp.Utilities;

namespace WebApiApp.Controllers
{
    [ApiController]
    [Route("api/[controller]")]
    public class UsersController : ControllerBase
{
    private readonly UserManager<User> _userManager;
    private readonly SignInManager<User> _signInManager;
    private readonly IConfiguration _configuration;

    public UsersController(
        UserManager<User> userManager, 
        SignInManager<User> signInManager,
        IConfiguration configuration
        )
    {
            //inject
        _userManager = userManager;
        _signInManager = signInManager;
        _configuration = configuration;
    }

    [HttpPost("register")]
    public async Task<IActionResult> Register([FromBody] RegisterRequestModel requestModel)
    {
        /*
            var passwordHasher = new PasswordHasher<User>();
        var hashedPassword = passwordHasher.HashPassword(null, requestModel.Password);
        */
            var user = new User
        {
            Email = requestModel.Email,
            UserName = requestModel.Email,
            FullName = requestModel.FullName ?? "",  
            PasswordHash = ""

            };


        var result = await _userManager.CreateAsync(user, requestModel.Password);

        if (result.Succeeded)
        {
            // User was created successfully            
            return Ok();
        }

        // User creation failed, return error messages
        return BadRequest(result.Errors);
    }
    

        [HttpPost("login")]
    public async Task<IActionResult> Login([FromBody] LoginRequestModel requestModel)
    {
            //var result = await _signInManager.PasswordSignInAsync(model.Email, model.Password, false, false);
            var user = await _userManager.FindByNameAsync(requestModel.Email);            
            if (user == null)
            {
                return BadRequest(new { message = "Invalid credentials." });
            }

            var result = await _signInManager
                            .CheckPasswordSignInAsync(
                            user, 
                            requestModel.Password, false);

            if (result.Succeeded)
            {
                
                var token = JWTToken.GenerateJwtToken(user, _configuration);

                return Ok(new { token });
            }
            else
            {
                return BadRequest(new { message = "Invalid credentials." });
            }

        }
    }
    
}
