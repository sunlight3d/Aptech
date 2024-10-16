using _03_07_2023.Models;
using _03_07_2023.Repositories;
using _03_07_2023.Services;
using _03_07_2023.Utilities;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Options;

namespace _03_07_2023
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.
            builder.Services.AddControllersWithViews();
            //options.UseSqlServer(Configuration.GetConnectionString("MyConnectionString"))
            string? connectionString = builder.Configuration?.GetConnectionString("MyConnectionString");

            builder.Services.AddDbContext<MyDBContext>(options => options.UseSqlServer(connectionString));

            // Đăng ký Repository
            builder.Services.AddScoped<IProductRepository, ProductRepository>();
            
            // Đăng ký Service
            builder.Services.AddScoped<IProductService, ProductService>();
            //environment variable            
            builder.Services.Configure<Utilities.Environments>(builder.Configuration?.GetSection("Environments"));
            var app = builder.Build();

            // Configure the HTTP request pipeline.
            if (!app.Environment.IsDevelopment())
            {
                app.UseExceptionHandler("/Home/Error");
                // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
                app.UseHsts();
            }

            app.UseHttpsRedirection(); //middleware, services
            app.UseStaticFiles();

            app.UseRouting();

            app.UseAuthorization();

            _ = app.UseEndpoints(endpoints =>
            {
                endpoints.MapControllerRoute(
                    name: "default",
                    pattern: "{controller=Home}/{action=Index}/{id?}");
            });
            //_ = dskjjdsd => khi biến trả về ko dùng đến => dùng biến dạng no name(_ = ) = Apple Swift
            /*
            app.MapControllerRoute(
                name: "default",
                pattern: "{controller=Home}/{action=Index}/{id?}");
            */
            app.Run();
            
        }
    }
}

/*
 * hello chao ban 
 * 
CREATE DATABASE c2204l;
USE c2204l;
CREATE TABLE Department (
    DepartmentId INT PRIMARY KEY IDENTITY(1, 1),
    DepartmentName VARCHAR(255) NOT NULL 
);

CREATE TABLE Employee (
    EmployeeId INT PRIMARY KEY IDENTITY(1, 1),
    EmployeeName VARCHAR(100),
    DepartmentId INT,
    FOREIGN KEY (DepartmentId) REFERENCES Department(DepartmentId)
);

CREATE TABLE tblUser (
    UserId INT PRIMARY KEY IDENTITY(1, 1),
    FullName VARCHAR(255) DEFAULT '',
    Email VARCHAR(255) NOT NULL,
    Password VARCHAR(255) CHECK (LEN(Password) > 3)
);

Hãy viết hộ connection string để đưa vào appsettings.json
với username: ALIENWARE\sunli, Windows Authentication
server name: ALIENWARE\SQLEXPRESS


 */