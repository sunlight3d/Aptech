using de07.Data;
using de07.Models;
using Microsoft.AspNetCore.Identity;
using Microsoft.EntityFrameworkCore;
/**
dotnet tool install --global dotnet-ef
dotnet build
dotnet ef database update
dotnet ef migrations add AddServiceEntities --context ApplicationDbContext
dotnet ef database update --context ApplicationDbContext


 */
var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");

builder.Services.AddDbContext<ApplicationDbContext>(options =>
    options.UseSqlServer(connectionString));
builder.Services.AddDatabaseDeveloperPageExceptionFilter();


builder.Services.AddDefaultIdentity<ApplicationUser>(options => options.SignIn.RequireConfirmedAccount = true)
    .AddEntityFrameworkStores<ApplicationDbContext>();
// Cấu hình tùy chỉnh cho mật khẩu
builder.Services.Configure<IdentityOptions>(options =>
{
    // Đặt độ dài mật khẩu tối thiểu là 8 ký tự
    options.Password.RequiredLength = 5;

    // Yêu cầu mật khẩu phải có ít nhất một chữ hoa
    options.Password.RequireUppercase = false;

    // Yêu cầu mật khẩu phải có ít nhất một chữ thường
    options.Password.RequireLowercase = true;

    // Yêu cầu mật khẩu phải có ít nhất một chữ số
    options.Password.RequireDigit = true;

    // Yêu cầu mật khẩu phải có ít nhất một ký tự đặc biệt
    options.Password.RequireNonAlphanumeric = false;

    // Yêu cầu xác nhận mật khẩu khi đăng ký
    options.Password.RequiredUniqueChars = 1;
});
/*
builder.Services.AddIdentity<ApplicationUser, IdentityRole>()
    .AddEntityFrameworkStores<ApplicationDbContext>()
    .AddDefaultTokenProviders(); 
*/
builder.Services.AddControllersWithViews();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseMigrationsEndPoint();
}
else
{
    app.UseExceptionHandler("/User/Error");
    // The default HSTS value is 30 days. You may want to change this for production scenarios, see https://aka.ms/aspnetcore-hsts.
    app.UseHsts();
}

app.UseHttpsRedirection();
app.UseStaticFiles();

app.UseRouting();
app.UseAuthentication();
app.UseAuthorization();

app.MapControllerRoute(
    name: "default",
    pattern: "{controller=User}/{action=Login}/{id?}");
//app.MapRazorPages();

app.Run();
