﻿using System.ComponentModel;

namespace StudentManagement.Models
{
    public class Student
    {
        public int StudentID { get; set; }
        [DisplayName("Student's name")]
        public string StudentName { get; set; }
        public string Email { get; set;}
        public string? Address { get; set; }
        public DateTime DOB { get; set; }

        //navigation property
        public ICollection<Enrollment> Enrollments { get; set; }
    }
}
