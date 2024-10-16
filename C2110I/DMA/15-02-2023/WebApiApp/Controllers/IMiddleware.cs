using Azure.Core;
using Microsoft.AspNetCore.Http.HttpResults;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Options;
using Microsoft.Extensions.Primitives;
using Microsoft.IdentityModel.Tokens;
using System.IdentityModel.Tokens.Jwt;
using System.Text;
using WebApiApp.Models;
using WebApiApp.Utilities;

namespace WebApiApp.Controllers
{
    public class JwtMiddleware : IMiddleware
    {
        
        private readonly UserManager<User> _userManager;
        private readonly IConfiguration _configuration;
        private readonly MyDBContext _dbContext;
        private string[] _ignoredPaths = new string[] {
            "/api/users/register",
            "/api/users/login",
            "/swagger/index.html",
            "/swagger/v1/swagger.json",
        }; 

        public JwtMiddleware(
            UserManager<User> userManager, 
            IConfiguration configuration,
            MyDBContext dBContext
            )
        {            
            _userManager = userManager;
            _configuration = configuration;
            _dbContext = dBContext; 
        }

        public async Task InvokeAsync(HttpContext httpContext, RequestDelegate next)
        {

            var path = httpContext?.Request?.Path.Value.ToLower() ?? "";

            if (_ignoredPaths.Any(p => path.StartsWith(p.ToLower())))
            {
                await next(httpContext);
                return;
            }

            var tokenHandler = new JwtSecurityTokenHandler();
            if (httpContext.Request.Headers.TryGetValue("Authorization",
                out StringValues authHeader))
            {
                //string token = authHeader.ToString();
                string[] authValues = authHeader.ToString()?.Trim().Split(' ');
                string token = authValues?[1];
                //require token
                string email = JWTToken.getEmailFromJWtToken(token, _configuration);
                if (!string.IsNullOrEmpty(email))
                {
                    //query db to get email 
                    User user = _dbContext.Users.Where(item => item.Email.Equals(email)).FirstOrDefault();
                    //return Ok(_context.Products.Take(100).ToList());
                    httpContext.Items["user"] = user;
                    await next(httpContext);
                    return;
                }                
            }
            else {
                httpContext.Response.StatusCode = 401;
                await httpContext.Response.WriteAsync("Authorization header is missing.");
                return;
            }
        }
    }

}
