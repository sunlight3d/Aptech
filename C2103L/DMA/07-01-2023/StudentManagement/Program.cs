
using Microsoft.EntityFrameworkCore;
using StudentManagement.Models;
using System.Security.Policy;

namespace StudentManagement
{
    public class Program
    {
        public static void Main(string[] args)
        {
            var builder = WebApplication.CreateBuilder(args);

            // Add services to the container.

            builder.Services.AddControllers();
            // Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
            builder.Services.AddEndpointsApiExplorer();
            builder.Services.AddSwaggerGen();
            //add services
            builder.Services.AddDbContext<StudentManagementContext>(option =>
                                option.UseInMemoryDatabase("StudentManagement"));

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
        }
    }
}
/*
Entities:
    Student
        -StudentID
        -StudentName
        -Address
        -Email
        -DOB
    Course
        -CourseID
        -CourseName
        -StartDate
        -Duration
    Enrollment
        -StudentID
        -CourseID
        -Grade


 */