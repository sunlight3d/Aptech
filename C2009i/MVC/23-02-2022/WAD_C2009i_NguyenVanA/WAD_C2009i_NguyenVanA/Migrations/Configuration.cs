namespace WAD_C2009i_NguyenVanA.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using WAD_C2009i_NguyenVanA.Models;

    internal sealed class Configuration : DbMigrationsConfiguration<WAD_C2009i_NguyenVanA.Models.DataContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(WAD_C2009i_NguyenVanA.Models.DataContext context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method
            //  to avoid creating duplicate seed data.
            base.Seed(context);
            Console.WriteLine("seeding 1234...");
            context.Students.Add(new Student()
            {
                StudentId = 1,
                StudentName = "Student A",
                StudentClass = "C2009i",
                StudentDOB = new DateTime(1993, 12, 31)
            });
            context.Students.Add(new Student()
            {
                StudentId = 2,
                StudentName = "Student B",
                StudentClass = "C2009i",
                StudentDOB = new DateTime(1980, 11, 25)
            });
            context.Students.Add(new Student()
            {
                StudentId = 3,
                StudentName = "Student C",
                StudentClass = "C2009i",
                StudentDOB = new DateTime(1998, 10, 20)
            });
            context.Students.Add(new Student()
            {
                StudentId = 4,
                StudentName = "Student D",
                StudentClass = "C2009i",
                StudentDOB = new DateTime(2000, 09, 15)
            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 1,
                SubjectName = "EPC",
            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 2,
                SubjectName = "ADF1",
            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 3,
                SubjectName = "WFPC#",
            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 4,
                SubjectName = "HTML",
            });
            context.Exams.Add(new Exam()
            {
                SubjectId = 1,
                StudentId = 1,
                Mark = 5,
            });
            context.Exams.Add(new Exam()
            {
                SubjectId = 2,
                StudentId = 1,
                Mark = 6,
            });
            context.Exams.Add(new Exam()
            {
                SubjectId = 2,
                StudentId = 3,
                Mark = 7,
            });
            context.Exams.Add(new Exam()
            {
                SubjectId = 3,
                StudentId = 4,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                SubjectId = 3,
                StudentId = 1,
                Mark = 10,
            });
            context.SaveChanges();
        }
    }
}
