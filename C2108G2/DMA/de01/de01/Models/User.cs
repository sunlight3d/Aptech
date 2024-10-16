using System;
using System.ComponentModel.DataAnnotations;

namespace de01.Models
{
    public class User
    {
        [Key]
        public int UsersID { get; set; }

        [StringLength(50, ErrorMessage = "Username cannot be longer than 50 characters")]
        public string UserName { get; set; }

        [StringLength(255, ErrorMessage = "Password cannot be longer than 255 characters")]
        public string Password { get; set; }

        [StringLength(255, ErrorMessage = "Description cannot be longer than 255 characters")]
        public string Description { get; set; }
    }
}

