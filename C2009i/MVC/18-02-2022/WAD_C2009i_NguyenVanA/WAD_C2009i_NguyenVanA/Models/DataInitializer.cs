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
            //create fake data
            context.Students.Add(new Student() { 
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
            context.SaveChanges();
        }
    }
}