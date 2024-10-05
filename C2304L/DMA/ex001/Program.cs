using ex001.Models;
using ex001.Services.Auth;
using ex001.Utilities;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;

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


builder.Services.AddDbContext<DataContext>(options =>
            options.UseSqlServer(connectionString));
builder.Services.AddHealthChecks()
            .AddSqlServer(connectionString, name: "SQL Server");
builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

builder.Services.AddScoped<IAuthService, AuthService>();

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
