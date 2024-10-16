using ex001.Authorization;
using ex001.Models;
using ex001.Services.Auth;
using ex001.Services.Token;
using ex001.Utilities;
using Microsoft.AspNetCore.Authentication.JwtBearer;
using Microsoft.AspNetCore.Authorization;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Tokens;

var builder = WebApplication.CreateBuilder(args);

var appSalt = Environment.GetEnvironmentVariable("APP_SALT") ?? "";
if (string.IsNullOrEmpty(appSalt))
{
    throw new InvalidOperationException("APP_SALT environment variable is not set.");
}
else {
    Console.WriteLine(appSalt);
}
// Add services to the container.
string connectionString = builder.Configuration.GetConnectionString("DefaultConnection") ?? "";

if (string.IsNullOrEmpty(connectionString))
{
    throw new InvalidOperationException("Connection string is null");
}

builder.Services.AddSingleton<DataContext>(provider =>
{
    var optionsBuilder = new DbContextOptionsBuilder<DataContext>();
    optionsBuilder.UseSqlServer(connectionString);

    return new DataContext(optionsBuilder.Options);
});
builder.Services.AddHealthChecks()
            .AddSqlServer(connectionString, name: "SQL Server");

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
            IssuerSigningKey = new SymmetricSecurityKey(System.Text.Encoding.UTF8.GetBytes(
                builder?.Configuration["Jwt:Key"] ?? ""))
        };
    });


builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddSingleton<IAuthService, AuthService>();
builder.Services.AddSingleton<ITokenService, TokenService>();
builder.Services.AddSingleton<IAuthorizationHandler, AdminRequirementHandler>();
builder.Services.AddSingleton<IHttpContextAccessor, HttpContextAccessor>();

builder.Services.AddAuthorization(options =>
{
    /*
    options.AddPolicy("LoginRequire", policy =>
            policy.Requirements.Add(new LoginRequirement()));
    */
    options.AddPolicy("AdminRequire", policy =>
            policy.Requirements.Add(new AdminRequirement()));

});
//builder.Services.AddSingleton<IPasswordHasher, PasswordHasher>();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}
/*
curl -X 'GET' \
  'http://localhost:5016/api/products' \
headers Authorixation Bearer token 
  -H 'accept: text/plain'
 */
app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();
app.MapHealthChecks("/health", new Microsoft.AspNetCore.Diagnostics.HealthChecks.HealthCheckOptions()
{
    ResponseWriter = async (context, report) =>
    {
        context.Response.ContentType = "application/json";
        var response = new
        {
            status = report.Status.ToString(),
            errors = report.Entries.Select(e => new { key = e.Key, value = e.Value.Status.ToString() })
        };
        //await context.Response.WriteAsync(JsonConvert.SerializeObject(response));
        await context.Response.WriteAsync(System.Text.Json.JsonSerializer.Serialize(response));
    }
}); 

app.Run();
