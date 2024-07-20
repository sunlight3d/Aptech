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
using UserHub.DTOs.Requests;
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

        public AuthController(IAuthService authService)
        {
            _authService = authService;
        }

        [HttpPost("register")]
        public async Task<ActionResult<UserResponse>> Register(RegisterUserRequest request)
        {
            var user = await _authService.RegisterUser(request.Email, request.Password, request.FullName);
            if (user == null)
            {
                return BadRequest("User already exists or other error.");
            }
            return UserResponse.FromUser(user);
        }
        

        [HttpPost("login")]
        public async Task<ActionResult<string>> Login(LoginUserRequest request)
        {
            var token = await _authService.AuthenticateUser(request.Email, request.Password);
            if (token == null)
            {
                return Unauthorized("Invalid email or password.");
            }
            return token;
        }
    }

}
