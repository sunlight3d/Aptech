using _03_07_2023.Validations;
using System.ComponentModel.DataAnnotations;
namespace _03_07_2023.DTOs
{
    public class UserRegisterRequest
    {
        //Model Validation
        [Required(ErrorMessage = "Email is required")]
        [EmailAddress(ErrorMessage = "Invalid email format")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Full Name is required")]
        public string FullName { get; set; }

        [Required(ErrorMessage = "Password is required")]
        [MinLength(3, ErrorMessage = "Mật khẩu tối thiểu 3 ký tự")]
        public string Password { get; set; }


        [Required(ErrorMessage = "ConfirmPassword is required")]
        [MinLength(3, ErrorMessage = "Mật khẩu tối thiểu 3 ký tự")]
        [Compare("Password", ErrorMessage = "ConfirmPassword does not match")]
        [MatchPassword("Password", ErrorMessage = "Passwords do not match")]
        public string ConfirmPassword { get; set; }
    }

}
