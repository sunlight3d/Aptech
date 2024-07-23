using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;
using System.Text;
using UserHub.DTOs.Responses;
using UserHub.Models;

namespace UserHub.Services
{
    public class AuthService : IAuthService
    {
        private readonly DataContext _context;
        private readonly IConfiguration _configuration;
        private readonly HMACSHA512 _hmac;

        public AuthService(DataContext context, IConfiguration configuration)
        {
            _context = context;
            _configuration = configuration;
            _hmac = new HMACSHA512(Encoding.ASCII.GetBytes(_configuration["HashPassword:Key"] ?? ""));
        }

        public async Task<UserResponse> RegisterUser(string email, string password, string fullName)
        {
            var existingUser = await _context.Users.SingleOrDefaultAsync(x => x.Email == email);
            if (existingUser != null)
            {
                return null; // User already exists
            }

            var user = new User
            {
                Email = email,
                PasswordHash = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(password))),
                FullName = fullName
            };

            _context.Users.Add(user);
            await _context.SaveChangesAsync();
            return UserResponse.FromUser(user);
        }

        public async Task<string> AuthenticateUser(string email, string password)
        {
            var user = await _context.Users.SingleOrDefaultAsync(x => x.Email == email);
            if (user == null)
            {
                return null; // User not found
            }

            var computedHash = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(password)));
            if (!computedHash.Equals(user.PasswordHash))
            {
                return null; // Password does not match
            }

            // Generate JWT token
            var tokenHandler = new JwtSecurityTokenHandler();
            var key = Encoding.ASCII.GetBytes(_configuration["Jwt:Key"] ?? "");
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                new Claim(ClaimTypes.NameIdentifier, user.Id.ToString()),
                new Claim(ClaimTypes.Email, user.Email),
                new Claim(ClaimTypes.Role, user.Role)
                }),
                Expires = DateTime.UtcNow.AddDays(1),
                SigningCredentials = new SigningCredentials(new SymmetricSecurityKey(key), SecurityAlgorithms.HmacSha512Signature)
            };

            var token = tokenHandler.CreateToken(tokenDescriptor);
            return tokenHandler.WriteToken(token);
        }
        public async Task<UserResponse> GetUserById(int id)
        {
            User user = await _context.Users.FindAsync(id);
            return UserResponse.FromUser(user);
        }

    }


}
