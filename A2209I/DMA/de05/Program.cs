using de05.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.Extensions.Configuration;
using Microsoft.EntityFrameworkCore.Design;

//var MyAllowSpecificOrigins = "_MyAllowSubdomainPolicy";

var builder = WebApplication.CreateBuilder(args);
/*
builder.Services.AddCors(options =>
{
    options.AddPolicy(name: MyAllowSpecificOrigins,
        policy =>
        {
            policy
                .AllowAnyOrigin()
                .AllowAnyMethod()            
                .AllowAnyHeader();
        });
});
*/
builder.Services.AddCors();
/**
dotnet dev-certs https --clean
dotnet dev-certs https --trust

dotnet tool install --global dotnet-ef
dotnet build
dotnet ef migrations add AddSomeEntities --context DataContext
dotnet ef database update --context DataContext

INSERT INTO Products (Name, Price, Description, Quantity) VALUES
('Product 1', 10.99, 'Description for product 1', 100),
('Product 2', 20.49, 'Description for product 2', 200),
('Product 3', 30.00, 'Description for product 3', 300),
('Product 4', 40.99, 'Description for product 4', 400),
('Product 5', 50.75, 'Description for product 5', 500);

INSERT INTO Orders (OrderDate, CustomerId, ProductId, Quantity) VALUES
('2023-07-01', 1, 1, 10),
('2023-07-02', 2, 2, 5),
('2023-07-03', 3, 3, 15),
('2023-07-04', 1, 4, 20),
('2023-07-05', 2, 5, 25);

 */
// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection") 
    ?? throw new InvalidOperationException("Connection string 'DefaultConnection' not found.");

builder.Services.AddDbContext<DataContext>(options =>
    options.UseSqlServer(connectionString));
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
