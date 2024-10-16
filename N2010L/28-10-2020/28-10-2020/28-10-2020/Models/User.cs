using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Threading.Tasks;

namespace _28_10_2020.Models
{
    public class User
    {
        [Key]
        public int UserId { get; set; }
        public string Email { get; set; }
        [Display(Name = "Year Of Birth")]
        public int YearOfBirth { get; set; }
        public string TokenKey { get; set; }
    }
}
