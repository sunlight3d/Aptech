using System;
using System.Data.Entity;
using System.Linq;
using EF_CodeFirst.Infra;

namespace EF_CodeFirst
{
    class Program
    {
        static void Main(string[] args)
        {
            // Initializing the database and populating seed data using DropCreateDatabaseIfModelChanges initializer
            using (var context = new SchoolContext()) {
                new DropCreateDBOnModelChanged().InitializeDatabase(context);
                var courses = from course in context.Courses
                              select course;
                foreach (var course in courses)
                {
                    Console.WriteLine("Course: {0}", course.Name);
                    foreach (var student in course.Students)
                    {
                        Console.WriteLine("\tStudent name: {0}", student.Name);
                    }
                }
                //n - n giua Courses va Students
                Console.ReadLine();
            }   
        }
    }
}
