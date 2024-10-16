using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StudentManagementConsole
{
    [Table("Student")]
    public class Student
    {
        [Key]
        [Column("Id")]
        public string Id { get; set; }
        
        [Column("FullName")]
        [StringLength(50)]
        public string FullName { get; set; }
        public string Gender { get; set; }
        public string PhoneNumber { get; set; }
        public int Height { get; set; }
        public DateTime DOB { get; set; }
        public override string ToString()
                        => $"Id: {Id}, " +
                            $"Full Name: {FullName}, " +
                            $"Gender: {Gender}, " +
                            $"Phone Number: {PhoneNumber}";
    }
}
