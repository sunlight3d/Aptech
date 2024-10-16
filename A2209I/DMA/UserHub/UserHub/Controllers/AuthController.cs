using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Identity;
using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;
using System.Text;
using UserHub.DTOs.Requests.User;
using UserHub.DTOs.Responses;
using UserHub.Models;
using UserHub.Services;

namespace UserHub.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private readonly IAuthService _authService;
        private readonly ITokenService _tokenService;

        public AuthController(IAuthService authService, ITokenService tokenService)
        {
            _authService = authService ?? throw new ArgumentNullException(nameof(authService));
            _tokenService = tokenService;
        }

        [HttpPost("register")]
        public async Task<ActionResult<UserResponse>> Register(RegisterUserRequest request)
        {
            var userResponse = await _authService.RegisterUser(request);
            if (userResponse == null)
            {
                return BadRequest("User already exists or other error.");
            }
            return userResponse;
        }
        

        [HttpPost("login")]
        [AllowAnonymous]
        public async Task<ActionResult<string>> Login(LoginUserRequest request)
        {
            var token = await _authService.AuthenticateUser(request);
            if (token == null)
            {
                return Unauthorized("Invalid email or password.");
            }
            return token;
        }
        [HttpPost("me")]
        [AllowAnonymous]
        public async Task<IActionResult> GetCurrentUser()
        {
            
            UserResponse? userResponse = await _tokenService.GetUserFromTokenHeaders(this.HttpContext);

            if (userResponse == null)
            {
                return Unauthorized("Invalid token or User not found");
            }
            return Ok(userResponse);
        }
    }

}
