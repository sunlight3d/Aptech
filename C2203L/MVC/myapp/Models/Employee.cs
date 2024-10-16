using Microsoft.AspNetCore.Authentication;
using System.ComponentModel.DataAnnotations;

namespace myapp.Models
{
    public class Employee
    {
        [Key]
        public int Id { get; set; }
        public string? Name { get; set; }

        public int DepartmentId { get; set; }
        public Department Department { get; set; }

        public int Age { get; set; }
        public string? Sex { get; set; }
    }
}
