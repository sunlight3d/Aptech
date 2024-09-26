using ex001.Utilities;

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

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

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

app.Run();
