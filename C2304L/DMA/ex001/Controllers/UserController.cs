using ex001.Dtos.Requests.User;
using ex001.Dtos.Responses;
using ex001.Utilities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ex001.Models;
using ex001.Services.Auth;
using Microsoft.EntityFrameworkCore;
using Microsoft.AspNetCore.Authorization;
using ex001.Services.Token;

namespace ex001.Controllers
{
    [Route("api/[controller]s")]
    [ApiController]
    public class UserController : ControllerBase
    {
        private readonly IAuthService _authService;
        private readonly ITokenService _tokenService;
        public UserController(IAuthService authService, ITokenService tokenService) {
            _authService = authService;
            _tokenService = tokenService;
        }
        [HttpPost("register")]
        [AllowAnonymous]
        public async Task<ActionResult<UserResponse>>  Register([FromBody] RegisterUserRequest request)
        {
            // Check if the model is valid
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState); // Return validation errors
            }
            //call services: Servicename.ServiceFunction(request)
            // convert from Model to Response, eg: User => UserResponse
            //khi nao dung data mapper
            var userResponse = await _authService.RegisterUser(request);
            if (userResponse == null)
            {
                return BadRequest("User already exists or other error.");
            }
            return Ok(userResponse); // Return success response
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
