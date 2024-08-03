using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Diagnostics.HealthChecks;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Hosting;
using Microsoft.IdentityModel.Tokens;
using System.Security.Claims;
using System.Text;
using UserHub.Authorization;
using UserHub.Helpers;
using UserHub.Middlewares;
using UserHub.Models;
using UserHub.Services;
/*
install Microsoft.EntityFrameworkCore.Design first !
dotnet tool install --global dotnet-ef
dotnet build

dotnet ef migrations add AddSomeEntities --context DataContext
dotnet ef database update --context DataContext

dotnet ef migrations add AddUniqueConstraintToPostTitle --context DataContext
dotnet ef database update --context DataContext



if you run this app using Docker container, you cannot access Db in Host

How to generate "private key" for JWT: Open Windows Powershell and type:
[Byte[]] $key = New-Object Byte[] 64  # 64 bytes for 512 bits
[Security.Cryptography.RNGCryptoServiceProvider]::Create().GetBytes($key)
[Convert]::ToBase64String($key)


 */
var builder = WebApplication.CreateBuilder(args);
builder.Services.AddCors();

var connectionString = builder.Configuration.GetConnectionString("DefaultConnection")
    ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");
/*
builder.Services.AddDbContext<DataContext>(options =>
    options.UseSqlServer(connectionString));
*/
builder.Services.AddSingleton<DataContext>(provider =>
{
    var optionsBuilder = new DbContextOptionsBuilder<DataContext>();
    optionsBuilder.UseSqlServer(connectionString);

    return new DataContext(optionsBuilder.Options);
});


builder.Services.AddAuthentication(options =>
{
    options.DefaultAuthenticateScheme = JwtBearerDefaults.AuthenticationScheme;
    options.DefaultChallengeScheme = JwtBearerDefaults.AuthenticationScheme;
})
    .AddJwtBearer(options =>
    {
        options.TokenValidationParameters = new TokenValidationParameters
        {
            ValidateIssuer = true,
            ValidateAudience = true,
            ValidateLifetime = true,
            ValidateIssuerSigningKey = true,
            ValidIssuer = builder.Configuration["Jwt:Issuer"],
            ValidAudience = builder.Configuration["Jwt:Audience"],
            IssuerSigningKey = new SymmetricSecurityKey(Encoding.UTF8.GetBytes(
                builder?.Configuration["Jwt:Key"] ?? ""))
        };
    });

builder.Services.AddScoped<IPostService, PostService>();
builder.Services.AddScoped<IAuthService, AuthService>();
//builder.Services.AddSingleton<ITokenService, TokenService>();
builder.Services.AddSingleton<ITokenService, TokenService>();

builder.Services.AddSingleton<IAuthorizationHandler, LoginRequirementHandler>();
builder.Services.AddSingleton<IAuthorizationHandler, AdminRequirementHandler>();
builder.Services.AddSingleton<IHttpContextAccessor, HttpContextAccessor>();
builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("LoginRequire", policy =>
            policy.Requirements.Add(new LoginRequirement()));    
    options.AddPolicy("AdminRequire", policy =>
            policy.Requirements.Add(new AdminRequirement()));

});
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddControllers();
//dotnet add package Microsoft.Extensions.Diagnostics.HealthChecks.EntityFrameworkCore
builder.Services.AddHealthChecks()           
           .AddDbContextCheck<DataContext>();

var app = builder.Build();
app.UseCors(x => x.AllowAnyHeader().AllowAnyMethod().WithOrigins("http://localhost:5173"));

app.MapHealthChecks("/healthz", new HealthCheckOptions
{
    AllowCachingResponses = true,
    ResponseWriter = HealthCheckResponseWriter.WriteResponse
}).RequireHost("*:*");
//.RequireAuthorization();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();
app.UseMiddleware<ErrorHandlingMiddleware>();

app.Run();
