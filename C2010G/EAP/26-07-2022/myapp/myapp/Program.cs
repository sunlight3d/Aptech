using Microsoft.EntityFrameworkCore;
using myapp.Models;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.

builder.Services.AddControllers();
builder.Services.AddDbContext<TodoContext>(opt =>
    opt.UseInMemoryDatabase("TodoList"));

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
app.MapGet("/", () => {
    return "This is root11";
});
//alpha = alphabet, ko co ky tu dac biet
app.MapGet("/hello/{name:alpha}/{year:int}", (string name, string year) => {
    Console.WriteLine("haha");
    return $"Hello {name}, year = {year}";
});
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}


app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();

