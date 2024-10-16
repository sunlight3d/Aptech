using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Diagnostics;

namespace StudentManagement.Models
{
    public enum Grade { 
        A, B, C, D, E
    }
    public class Enrollment
    {
        
        public int EnrollmentID { get; set; }
        //[Key, Column(Order = 0)]        
        public int StudentID { get; set; }
        //[Key, Column(Order = 1)]
        public int CourseID { get; set; }
        public Grade Grade { get; set; }

        public virtual Student Student {get; set;}
        public virtual Course Course { get; set; }
    }
}
