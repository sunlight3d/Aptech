using Microsoft.AspNetCore.Identity;
using System.ComponentModel.DataAnnotations;

namespace de07.Models
{
    
    public class ApplicationUser : IdentityUser
    {
        [Required(ErrorMessage = "Address is required")]
        public string AddressHome { get; set; }

        [StringLength(15, ErrorMessage = "Phone number cannot be longer than 15 digits")]
        public string PhoneHome { get; set; }

        [Required(ErrorMessage = "Job title is required")]
        public string Job { get; set; }
    }

}
