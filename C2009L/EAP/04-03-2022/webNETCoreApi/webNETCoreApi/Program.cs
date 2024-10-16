using Microsoft.EntityFrameworkCore;
using webNETCoreApi.Models;

var builder = WebApplication.CreateBuilder(args);
//add services
builder.Services.AddDbContext<TodoDb>(opt => opt.UseInMemoryDatabase("TodoList"));
builder.Services.AddDatabaseDeveloperPageExceptionFilter();
// Add services to the container.

builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();
app.MapGet("/", () =>
{
    //Load in-memory database 
    return "<h1>Hello</h1>";
});
app.MapGet("/todos", async (TodoDb db) =>
{
    await db.Todos.Where(eachTodo => eachTodo.IsCompleted)
    .ToListAsync();
});
app.MapPost("/todos", async (Todo todo, TodoDb db) =>
{
    //db = inject a service
    db.Todos.Add(todo);
    await db.SaveChangesAsync();
    //forward to another api
    return Results.Created($"/todos{todo.Id}", todo); //show
});
//get details
app.MapGet("/todos/{id}", async (int id,TodoDb db) =>
{
    return await db.Todos.FindAsync(id) is Todo todo 
                ? Results.Ok(todo) : Results.NotFound(); 
});
app.MapPut("/todos/{id}", async (int id, Todo inputTodo, TodoDb db) =>
{
    var todo = await db.Todos.FindAsync(id);
    if (todo is null) { 
        return Results.NotFound();
    }
    todo.Name = inputTodo.Name;
    todo.IsCompleted = inputTodo.IsCompleted;
    await db.SaveChangesAsync();
    return Results.NoContent();
});
// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();//show API's details
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
