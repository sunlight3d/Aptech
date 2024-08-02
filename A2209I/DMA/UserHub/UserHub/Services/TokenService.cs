using Microsoft.EntityFrameworkCore;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using UserHub.DTOs.Responses;
using UserHub.Models;

namespace UserHub.Services
{
    public class TokenService : ITokenService
    {
        private readonly IConfiguration _configuration;
        private readonly DataContext _context;  // Your DbContext might be named differently

        
        public TokenService(IConfiguration configuration, DataContext context)
        {
            _configuration = configuration;
            _context = context;
        }

        public async Task<UserResponse?> GetUserFromTokenHeaders(HttpContext httpContext)
        {
            // Extract token from the Authorization header
            string authorizationHeader = httpContext.Request.Headers["Authorization"].ToString();
            if (string.IsNullOrEmpty(authorizationHeader) || !authorizationHeader.StartsWith("Bearer "))
            {
                return null; // No token found
            }

            string token = authorizationHeader["Bearer ".Length..].Trim(); // Correct extraction of the token
            var tokenHandler = new JwtSecurityTokenHandler();

            var securityKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(_configuration["Jwt:Key"]));
            var tokenValidationParameters = new TokenValidationParameters
            {
                ValidateIssuerSigningKey = true,
                IssuerSigningKey = securityKey,
                ValidateIssuer = false,
                ValidateAudience = false,
                ValidateLifetime = true,
                ClockSkew = TimeSpan.Zero
            };

            SecurityToken validatedToken;
            var principal = tokenHandler.ValidateToken(token, tokenValidationParameters, out validatedToken);
            var userIdClaim = principal.FindFirst(ClaimTypes.NameIdentifier)?.Value;
            if (userIdClaim == null)
            {
                return null; // No user ID found in the token
            }

            if (!int.TryParse(userIdClaim, out int userId))
            {
                return null; // User ID is not in the correct format
            }

            // Using async method to find the user in the database
            User user = await _context.Users.FindAsync(userId);
            // Check if user is locked
            if (user == null)
            {
                return null; // No user found with this ID
            }

            // Assuming you have a UserResponse class that you want to fill with user data
            return UserResponse.FromUser(user);
        }

    }

}
