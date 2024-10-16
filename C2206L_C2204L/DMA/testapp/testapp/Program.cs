using Microsoft.EntityFrameworkCore;
using testapp.Models;
using testapp.Controllers;
using System.Net;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();
builder.Services.AddDbContext<DataContext>(options =>
                options.UseSqlServer(builder.Configuration.GetConnectionString("SQLServer2017")));
builder.Services.AddScoped<DataSeeder>();

builder.Services.AddCors(options =>
{
    options.AddDefaultPolicy(builder =>
    {
        
        builder.AllowAnyOrigin()        
               .AllowAnyMethod()
               .AllowAnyHeader();
    });
});

//builder.WebHost.UseUrls("http://127.0.0.1:5000");

builder.WebHost.ConfigureKestrel(kestrelServerOptions =>
{
    kestrelServerOptions.Listen(IPAddress.Loopback, 5002);
});
var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseCors();

app.UseAuthorization();

app.MapControllers();


app.Run();
