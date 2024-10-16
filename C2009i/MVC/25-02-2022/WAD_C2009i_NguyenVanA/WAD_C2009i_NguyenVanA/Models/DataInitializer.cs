using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            Console.WriteLine("Seeding...");
            //create fake data
            /*
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
            */
        }
    }
}