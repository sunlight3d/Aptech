using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C1908i_DuongDucAnh.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            context.Subjects.Add(new Subject() {
                SubjectId = 1,
                SubjectName = "Java",

            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 2,
                SubjectName = "C# programming",

            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 3,
                SubjectName = "Boostraps",

            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 4,
                SubjectName = "Android Programming",

            });
            context.Subjects.Add(new Subject()
            {
                SubjectId = 5,
                SubjectName = "Python",

            });
            //5 students
            context.Students.Add(new Student() { 
                StudentId = 1,
                StudentName = "Nguyen Van A",
                StudentDOB = new DateTime(1996, 12, 21),
                StudentClass = "C2009L"
            });
            context.Students.Add(new Student()
            {
                StudentId = 1,
                StudentName = "Tran Tuan Anh",
                StudentDOB = new DateTime(2000, 05, 12),
                StudentClass = "A1908L"
            });
            context.Students.Add(new Student()
            {
                StudentId = 1,
                StudentName = "Nguyen Duc Anh",
                StudentDOB = new DateTime(1998, 06, 06),
                StudentClass = "A2009C"
            });
            context.Students.Add(new Student()
            {
                StudentId = 1,
                StudentName = "Tran Van X",
                StudentDOB = new DateTime(1997, 08, 22),
                StudentClass = "C2009L"
            });
            context.Students.Add(new Student()
            {
                StudentId = 1,
                StudentName = "Nguyen Van C",
                StudentDOB = new DateTime(2001, 01, 21),
                StudentClass = "C1234L"
            });
            //10 samples of 'Exam'
            context.Exams.Add(new Exam() { 
                StudentId = 1,
                SubjectId = 2,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 4,
                SubjectId = 4,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 5,
                SubjectId = 5,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 4,
                SubjectId = 5,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 5,
                SubjectId = 3,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 1,
                SubjectId = 1,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 2,
                SubjectId = 2,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 2,
                SubjectId = 3,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 3,
                SubjectId = 4,
                Mark = 8,
            });
            context.Exams.Add(new Exam()
            {
                StudentId = 2,
                SubjectId = 1,
                Mark = 7,
            });
        }
    }
}