using System.ComponentModel.DataAnnotations;

namespace de07.ViewModels
{
    public class RegisterViewModel
    {
        [Required]
        [EmailAddress]
        [Display(Name = "Email")]
        public string Email { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "The {0} must be at least {2} characters long.", MinimumLength = 6)]
        [DataType(DataType.Password)]
        [Display(Name = "Password")]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Display(Name = "Confirm password")]
        [Compare("Password", ErrorMessage = "The password and confirmation password do not match.")]
        public string ConfirmPassword { get; set; }

        [Required(ErrorMessage = "Address is required")]
        public string AddressHome { get; set; }

        [StringLength(15, ErrorMessage = "Phone number cannot be longer than 15 digits")]
        public string PhoneHome { get; set; }

        [Required(ErrorMessage = "Job title is required")]
        public string Job { get; set; }
    }

}
