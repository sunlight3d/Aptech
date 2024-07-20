using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Hosting;
using Microsoft.IdentityModel.Tokens;
using System.Security.Claims;
using System.Text;
using UserHub.Models;
/*
install Microsoft.EntityFrameworkCore.Design first !
dotnet tool install --global dotnet-ef
dotnet build

dotnet ef migrations add AddSomeEntities --context DataContext
dotnet ef database update --context DataContext

if you run this app using Docker container, you cannot access Db in Host
 */
var builder = WebApplication.CreateBuilder(args);

var connectionString = builder.Configuration.GetConnectionString("DefaultConnection")
    ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");

builder.Services.AddDbContext<DataContext>(options =>
    options.UseSqlServer(connectionString));
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

builder.Services.AddAuthorization(options =>
{
    options.AddPolicy("RequireAdministratorRole", policy => policy.RequireRole("admin"));
    options.AddPolicy("RequireUserRole", policy => policy.RequireRole("user"));

    options.AddPolicy("EditOwnPost", policy =>
        policy.RequireClaim("UserId") // Ensure user's ID is in the claim
              .RequireAssertion(context =>
                  context.User.HasClaim(ClaimTypes.Role, "user") &&
                  context.Resource is Post post &&
                  post.UserId == int.Parse(context.User.FindFirst(ClaimTypes.NameIdentifier)?.Value)));

    options.AddPolicy("EditAnyPost", policy =>
        policy.RequireRole("Admin"));
});


builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
