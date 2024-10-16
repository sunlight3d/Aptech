using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace De02.Models
{
    public class Student
    {
        public int StudentId { get; set; }
        public String StudentName { get; set; }
        public int Gender { get; set; }        
        public DateTime DateOfBirth { get; set; }
        public String Address { get; set; }
        public String ClassCode { get; set; }
        public String UserName { get; set; }
        public String password { get; set; }
        
    }
}
