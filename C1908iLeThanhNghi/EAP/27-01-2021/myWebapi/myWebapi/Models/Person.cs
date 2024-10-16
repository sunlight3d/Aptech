using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace myWebapi.Models
{
    public class Person
    {
        [Key]
        public int Id { get; set; }

        [Required(ErrorMessage ="Name must not be blank")]
        [StringLength(200, MinimumLength = 2)]
        public String Name { get; set; }
        public String Email { get; set; }
        public int Age { get; set; }
    }
}
