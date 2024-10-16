using System;
using System.Collections.Generic;
namespace MyProject.Models
{
    public class Student
    {
        public Student()
        {
            this.Courses = new HashSet<Course>();
        }

        public int StudentId { get; set; }
        public string FirstName { get; set; }
        public string LastName { get; set; }
        //1 Student tham gia nhieu khoa hoc
        public ICollection<Course> Courses { get; set; }
        

    }
}
