using System;
using System.ComponentModel.DataAnnotations;

namespace de01Client.ViewModels
{
	public class LoginViewModel
	{
        [Required]
        public String UserName { get; set; }
        [Required]
        public String Password { get; set; }
    }
}

