using bai05.Models;
using Microsoft.EntityFrameworkCore;
using bai05.Controllers;
using bai05.Filters;
using Microsoft.AspNetCore.Authorization;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
builder.Services.AddControllersWithViews();
/*
builder.Services.AddDbContext<DataContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("DefaultConnection")));
*/
builder.Services.AddDbContext<DataContext>(options =>
    options.UseSqlServer(builder.Configuration["ConnectionStrings:DefaultConnection"]));
builder.Services.AddSingleton<IAuthorizationHandler, RoleHandler>();
builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("Read", policy => policy.Requirements.Add(new RoleRequirement { Role = "ReadAccess_Custom_System" }));
});

builder.Services
    .AddAuthentication()
    .AddBearerToken();  //👈
builder.Services.AddAuthorization();

builder.Services.AddEndpointsApiExplorer();

builder.Services.AddSwaggerGen();
builder.Services.AddDataProtection();
var app = builder.Build();

// Configure the HTTP request pipeline.
if (!app.Environment.IsDevelopment())
{
    app.UseExceptionHandler("/Home/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
};

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();

app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=Product}/{action=Index}/{id?}");

app.MapProductEndpoints();

app.Run();
/*
 T?o cho t�i 2 b?ng sau d�y, c�c r�ng bu?c vi?t ri�ng dua v�o c�u l?nh t?o b?ng: 
 Create a table named Products with the following columns:
Id (int, primary key)
Name (string, required, min length 5, max length 255)
Price (decimal, required, min value 0)
Description (string)
Quantity (int, required, min value 0)
Create a table named Orders with the following columns:
Id (int, primary key)
OrderDate (datetime)
CustomerPhone (string, min length 6, max length 15, required)
ProductId (int, foreign key)
Quantity (int, required, min value 1)
 */
