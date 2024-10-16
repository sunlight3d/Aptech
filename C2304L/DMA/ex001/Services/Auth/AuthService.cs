using ex001.Dtos.Requests.User;
using ex001.Dtos.Responses;
using ex001.Models;
using ex001.Services.Auth;
using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Security.Cryptography;
using System.Text;
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

    public async Task<UserResponse> RegisterUser(RegisterUserRequest request)
    {
        var existingUser = await _context.Users.SingleOrDefaultAsync(x => x.Email == request.Email);
        if (existingUser != null)
        {
            return null; // User already exists
        }

        var user = new User
        {
            Email = request.Email,

            Password = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password))),
            FullName = request.FullName
        };

        _context.Users.Add(user);
        await _context.SaveChangesAsync();
        return UserResponse.FromUser(user);
    }

    public async Task<string> AuthenticateUser(LoginUserRequest request)
    {
        var user = await _context.Users.SingleOrDefaultAsync(u => u.Email == request.Email);
        if (user == null)
        {
            return null; // User not found
        }

        var computedHash = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password)));
        if (!computedHash.Equals(user.Password))
        {
            return null; // Password does not match
        }
        //password matched
        // Generate JWT token
        var tokenHandler = new JwtSecurityTokenHandler();
        var key = Encoding.ASCII.GetBytes(_configuration["Jwt:Key"] ?? "");
        int expirationSeconds = int.Parse(_configuration["Jwt:ExpirationSeconds"]);
        var tokenDescriptor = new SecurityTokenDescriptor
        {
            Subject = new ClaimsIdentity(new Claim[]
            {
                new Claim(ClaimTypes.NameIdentifier, user.Id.ToString()),
                new Claim(ClaimTypes.Email, user.Email),
                //new Claim(ClaimTypes.Role, user.Role)
            }),
            Expires = DateTime.UtcNow.AddSeconds(expirationSeconds),
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
/*
namespace ex001.Services.Auth
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

        public async Task<UserResponse> RegisterUser(RegisterUserRequest request)
        {
            var existingUser = await _context.Users.SingleOrDefaultAsync(x => x.Email == request.Email);
            if (existingUser != null)
            {
                return null; // User already exists
            }

            var user = new User
            {
                Email = request.Email,
                Password = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password))),
                FullName = request.FullName
            };

            _context.Users.Add(user);
            await _context.SaveChangesAsync();
            return UserResponse.FromUser(user);
        }

        public async Task<string> AuthenticateUser(LoginUserRequest request)
        {
            var user = await _context.Users.SingleOrDefaultAsync(u => u.Email == request.Email);
            if (user == null)
            {
                return null; // User not found
            }

            var computedHash = Convert.ToBase64String(_hmac.ComputeHash(Encoding.UTF8.GetBytes(request.Password)));
            if (!computedHash.Equals(user.Password))
            {
                return null; // Password does not match
            }
            //password matched
            // Generate JWT token
            var tokenHandler = new JwtSecurityTokenHandler();
            var key = Encoding.ASCII.GetBytes(_configuration["Jwt:Key"] ?? "");
            int expirationSeconds = int.Parse(_configuration["Jwt:ExpirationSeconds"]);
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                new Claim(ClaimTypes.NameIdentifier, user.Id.ToString()),
                new Claim(ClaimTypes.Email, user.Email),
                //new Claim(ClaimTypes.Role, user.Role)
                }),
                Expires = DateTime.UtcNow.AddSeconds(expirationSeconds),
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
*/
