using Microsoft.AspNetCore.DataProtection.KeyManagement;
using System;
using System.ComponentModel.DataAnnotations;

namespace myapp.Models
{
    public class Student
    {
        [Key]
        public int ID { get; set; }
        public string Name { get; set; }
        public DateOnly DOB { get; set; }
        public int KlassId { get; set; }
        public Klass Klass { get; set; }
    }        
}
