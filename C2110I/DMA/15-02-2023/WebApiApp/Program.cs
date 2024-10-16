
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.DependencyInjection;
using WebApiApp.Controllers;
using WebApiApp.Models;

namespace WebApiApp
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();

            if (builder.Configuration.GetValue<bool>("UseInMemoryDatabase"))
            {
                builder.Services.AddDbContext<MyDBContext>(options =>
                options.UseInMemoryDatabase(databaseName: "C2110i"));//no connection string
            }
            else {
                builder.Services.AddDbContext<MyDBContext>(options =>
                options.UseSqlServer(builder.Configuration.GetConnectionString("SQLServerConnection")));
            }

            builder.Services.AddIdentity<User, IdentityRole>()
                    .AddEntityFrameworkStores<MyDBContext>()
                    .AddDefaultTokenProviders();
            builder.Services.AddScoped<JwtMiddleware>();
            builder.Services.AddCors(options =>
            {
                options.AddDefaultPolicy(builder =>
                {
                    builder.AllowAnyOrigin()
                           .AllowAnyHeader()
                           .AllowAnyMethod();
                });
            });

            builder.Services.Configure<IdentityOptions>(options =>
            {
                // Remove the PasswordRequiresNonAlphanumeric requirement
                options.Password.RequireNonAlphanumeric = false;
                // Set other password requirements as desired
                options.Password.RequireDigit = true;
                options.Password.RequireLowercase = false;
                options.Password.RequireUppercase = false;
                options.Password.RequiredLength = 6;
                //options.User.AllowedUserNameCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-._@+";
            });

            var app = builder.Build();
            app.UseCors();
            app.UseMiddleware<JwtMiddleware>();//validate token

            // Configure the HTTP request pipeline.
            if (app.Environment.IsDevelopment())
            {
                app.UseSwagger();
                app.UseSwaggerUI();
            }

            app.UseHttpsRedirection();
            
            app.UseAuthentication();
            app.UseAuthorization();

            app.MapControllers();

            app.Run();
        }
    }
}