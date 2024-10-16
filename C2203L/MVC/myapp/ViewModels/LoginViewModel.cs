using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Diagnostics.Metrics;

namespace myapp.ViewModels
{
    public class LoginViewModel
    {
        [Required]
        [MinLength(4, ErrorMessage = "Name must be at least 4 characters")]
        public string UserName { get; set; }
        [Required(ErrorMessage ="You must enter password")]        
        public string Password { get; set; }
        
        public bool RememberPassword { get; set; }
    }
}

