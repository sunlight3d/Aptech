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

namespace UserHub.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class AuthController : ControllerBase
    {
        private IConfiguration _config;
        private readonly DataContext _context;
        private HMACSHA512 hmac;

        public AuthController(IConfiguration config, DataContext context)
        {
            _config = config;
            _context = context;
            this.hmac = new HMACSHA512(Encoding.ASCII.GetBytes(_config["HashPassword:Key"] ?? ""));
        }

        [HttpPost("register")]
        public async Task<ActionResult<UserResponse>> Register(RegisterUserRequest request)
        {
            // Create hash and salt for the password
            try
            {
                var user = await _context.Users.SingleOrDefaultAsync(x => x.Email == request.Email);

                if (user != null)
                {
                    return BadRequest("User has already exists");
                }

                user = new User
                {
                    Email = request.Email,
                    PasswordHash = Convert.ToBase64String(hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password))),
                    FullName = request.FullName
                };

                _context.Users.Add(user);
                await _context.SaveChangesAsync();

                return UserResponse.FromUser(user);
            }
            catch (Exception e) {

                //e is DbUpdateException, ((DbUpdateException)e).Entries
                return BadRequest(e?.InnerException?.Message ?? "");
            }
        }

        [HttpPost("login")]
        public async Task<ActionResult<string>> Login(LoginUserRequest request)
        {
            //hoang12@gmail.com / 123456
            var user = await _context.Users.SingleOrDefaultAsync(x => x.Email == request.Email);

            if (user == null)
            {
                return Unauthorized("Invalid email");
            }

            var computedHash = Convert.ToBase64String(hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password)));
            if (!computedHash.Equals(user.PasswordHash)) {
                return Unauthorized("Invalid password");
            }
            
            // JWT token creation
            var tokenHandler = new JwtSecurityTokenHandler();
            var key = Encoding.ASCII.GetBytes(s: _config["Jwt:Key"] ?? "");
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                new Claim(ClaimTypes.NameIdentifier, user.UserId.ToString()),
                new Claim(ClaimTypes.Email, user.Email),
                new Claim(ClaimTypes.Role, user.Role)
                }),
                Expires = DateTime.UtcNow.AddDays(1),
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha512Signature)
            };

            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
    }
}
