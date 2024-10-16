using AutoMapper;
using HotChocolate.Types.Relay;
using HotChocolate.Types;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Data.SqlClient;
using Microsoft.EntityFrameworkCore;
using myapp.Models;
using myapp.ViewModels;
using System.Data;
using System.Drawing;
using System.Collections;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.AspNetCore.Authorization;
using System.Security.Cryptography;
using myapp.Services;

namespace myapp.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UserController : ControllerBase
    {        
        private readonly IUserService _userService;

        public UserController(IUserService userService)
        {
            _userService = userService;
        }
        // POST: api/Users/Register
        [HttpPost("Register")]
        public async Task<ActionResult> Register([FromBody] RegisterViewModel registerViewModel)
        {
            User? newUser = await _userService.Register(registerViewModel);

            if (newUser != null)
            {
                return CreatedAtAction("GetUser", new { id = newUser.UserId }, newUser);
            }
            else
            {
                return NotFound();
            }
        }
        [HttpGet("{id}")]        
        public async Task<ActionResult<User>> GetUser(int id)
        {
            var user = await _userService.GetUserById(id);

            if (user == null)
            {
                return NotFound();
            }

            return user;
        }

        // POST: api/Users/Login
        [HttpPost("Login")]
        [AllowAnonymous]
        public async Task<IActionResult> Login(LoginViewModel loginViewModel)
        {
            try
            {
                var token = await _userService.Authenticate(loginViewModel);
                return Ok(new { token });
            }
            catch (ApplicationException ex)
            {
                return BadRequest(new { message = ex.Message });
            }
        }        
    }
}
