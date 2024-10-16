using System;
using Microsoft.Data.SqlClient;
using Microsoft.IdentityModel.Tokens;
using myapp.Models;
using myapp.ViewModels;
using System.IdentityModel.Tokens.Jwt;
using System.Security.Claims;
using System.Text;
using Microsoft.EntityFrameworkCore;

namespace myapp.Services
{
    public class UserService : IUserService
    {
        private readonly IConfiguration _config;
        private readonly ApplicationDbContext _context;

        public UserService(IConfiguration config, ApplicationDbContext context)
        {
            _config = config;
            _context = context;
        }

        public async Task<string> Authenticate(LoginViewModel loginViewModel)
        {
            User? user = CheckLogin(loginViewModel.Email, loginViewModel.Password);
            if (user == null)
            {
                throw new ApplicationException("Email hoặc mật khẩu không chính xác");
            }

            var tokenHandler = new JwtSecurityTokenHandler();
            var key = Encoding.ASCII.GetBytes(_config?.GetValue<string>("JwtSecret") ?? "");
            var tokenDescriptor = new SecurityTokenDescriptor
            {
                Subject = new ClaimsIdentity(new Claim[]
                {
                new Claim("userId", user.UserId.ToString()),
                    //new Claim("Email", user.UserId.ToString()),
                }),
                Expires = DateTime.UtcNow.AddDays(30),
                SigningCredentials = new SigningCredentials(
                    new SymmetricSecurityKey(key),
                    SecurityAlgorithms.HmacSha256Signature)
            };
            var token = tokenHandler.CreateToken(tokenDescriptor);
            var tokenString = tokenHandler.WriteToken(token);

            var deviceCount = await _context.UserDevices.CountAsync(
                userDevice => userDevice.UserId == user.UserId);

            if (deviceCount >= 3)
            {
                var firstDevice = await _context.UserDevices
                    .FirstAsync(d => d.UserId == user.UserId);
                firstDevice.DeviceId = loginViewModel.DeviceId;
                firstDevice.Token = tokenString;
                firstDevice.TokenExpiration = tokenDescriptor.Expires.Value;

                await _context.SaveChangesAsync();
            }
            else
            {
                if (_context.UserDevices
                    .Where(userDevice => userDevice.DeviceId == loginViewModel.DeviceId)
                    .FirstOrDefault() != null)
                {
                    UserDevice existingUserDevice = _context.UserDevices
                                                .Where(userDevice =>
                                                    userDevice.DeviceId == loginViewModel.DeviceId)
                                                .FirstOrDefault()!;
                    existingUserDevice.Token = tokenString;
                    existingUserDevice.TokenExpiration = tokenDescriptor.Expires.Value;
                    await _context.SaveChangesAsync();
                }
                else
                {
                    var userDevice = new UserDevice
                    {
                        UserId = user.UserId,
                        DeviceId = loginViewModel.DeviceId,
                        Token = tokenString,
                        TokenExpiration = tokenDescriptor.Expires.Value
                    };
                    _context.UserDevices.Add(userDevice);
                    await _context.SaveChangesAsync();
                }
            }
            return tokenString;
        }

        private User? CheckLogin(string email, string password)
        {
            var sql = @"EXEC dbo.CheckLogin @Email, @Password;";
            return _context.Users.FromSqlRaw(sql,
                    new SqlParameter("@Email", email),
                    new SqlParameter("@Password", password)
                ).AsEnumerable()?.FirstOrDefault();
        }
        public async Task<User?> Register(RegisterViewModel registerViewModel)
        {
            // Call the stored procedure to register the user
            var parameters = new[]
            {
            new SqlParameter("@username", registerViewModel.Username),
            new SqlParameter("@password", registerViewModel.Password),
            new SqlParameter("@email", registerViewModel.Email),
            new SqlParameter("@phone", registerViewModel.Phone),
            new SqlParameter("@full_name", registerViewModel.FullName),
            new SqlParameter("@date_of_birth", registerViewModel.DateOfBirth),
            new SqlParameter("@country", registerViewModel.Country)
        };

            var sql = "EXECUTE RegisterUser " +
                      "@username, " +
                      "@password, " +
                      "@email, " +
                      "@phone, " +
                      "@full_name, " +
                      "@date_of_birth, " +
                      "@country";

            IEnumerable<User> result = await _context.Users
                .FromSqlRaw(sql, parameters)
                .ToListAsync();

            User? newUser = result.FirstOrDefault();

            return newUser;
        }
        public async Task<User?> GetUserById(int id)
        {
            return await _context.Users
                .SingleOrDefaultAsync(u => u.UserId == id);
        }
    }
}

