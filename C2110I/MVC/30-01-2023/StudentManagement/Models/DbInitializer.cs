using Microsoft.EntityFrameworkCore;

namespace StudentManagement.Models
{
    public static class DbInitializer
    {
        private static void RemoveAll(StudentManagementContext context) {
            foreach (var enrollment in context.Enrollments)
            {
                context.Enrollments.Remove(enrollment);
            }
            context.SaveChanges();
            foreach (var student in context.Students)
            {
                context.Students.Remove(student);
            }
            context.SaveChanges();
            foreach (var course in context.Courses)
            {
                context.Courses.Remove(course);
            }
            context.SaveChanges();
        }
        public static void Initialize(StudentManagementContext context)
        {
            //Dependency Injection

            try
            {
                context.Database.EnsureCreated();//prepare update
                RemoveAll(context);

                // Look for any students.

                if (context.Students.Any())
                {
                    return;   // DB has been seeded(faked data)
                }

                var students = new Student[]
                {
                new Student {
                    StudentName = "Nguyen Van A",
                    DOB = DateTime.Parse("1993-12-22"),
                    Email = "nguyenvaa@gmail.com",
                    Address = "Nha A, ngo B"
                },
                new Student {
                    StudentName = "Alan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "alanba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },

                new Student {
                    StudentName = "Afmdkjmfkdflan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "a222lanba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },
                new Student {
                    StudentName = "Aaedwelan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "al334anba@gmail.com",
                    Address = "Nhsswwsa A, nssgo B"
                },
                new Student {
                    StudentName = "Alan3234",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "aedsdlanba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },
                new Student {
                    StudentName = "A33442lan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "al33anba@gmail.com",
                    Address = "Nhsdddssa A, nssgo B"
                },
                new Student {
                    StudentName = "ddeer222",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "ala43466nba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },
                new Student {
                    StudentName = "Adfd22lan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "alanba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },
                new Student {
                    StudentName = "A44d3elan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "alanba@gmail.com",
                    Address = "Nhsssa A, nssgo B"
                },
                new Student {
                    StudentName = "Adsasds323lan",
                    DOB = DateTime.Parse("1993-11-25"),
                    Email = "alawwwnba@gmail.com",
                    Address = "ww A, nssgo B"
                },

                };

                foreach (Student s in students)
                {
                    context.Students.Add(s); //insert multiple in SQL
                }
                context.SaveChanges();//commit

                var courses = new Course[]
                {
                new Course { 
                    //init "builder pattern"
                    CourseID = 1111,
                    CourseName = "SQL Server",
                    Duration = 40,
                    Description = "Khoa hoc SQL SErver cho nguoi moi",
                    StartDate = DateTime.Parse("2022-06-05")
                },
                new Course {
                    CourseID = 2222,
                    CourseName = "Unity game C#",
                    Duration = 20,
                    Description = "Lap trinh game",
                    StartDate = DateTime.Parse("2020-05-05")
                },
                 };
                foreach (Course c in courses)
                {
                    context.Courses.Add(c);
                }
                context.SaveChanges();

                var enrollments = new Enrollment[]
                {
                new Enrollment{
                    StudentID = students[0].StudentID,
                    CourseID = courses[1].CourseID,
                    Grade = Grade.A,
                },
                new Enrollment{
                    StudentID = students[1].StudentID,
                    CourseID = courses[0].CourseID,
                    Grade = Grade.C,
                    Remarks = "This is good"
                },
                };
                foreach (Enrollment e in enrollments)
                {
                    context.Enrollments.Add(e);
                }
                context.SaveChanges();//commit
            }
            catch (Exception e) { 
                Console.WriteLine(e.ToString());    
            }
        }
    }
}
