using System.ComponentModel.DataAnnotations;

namespace ECommerceApp.ViewModels
{
    public class RegisterViewModel
    {
        //ViewModel = client send data(ViewModel) to server
        [EmailAddress]
        public string Email { get; set; }
        [Required(ErrorMessage = "Password is required.")]        
        [DataType(DataType.Password)]
        [RegularExpression(@"^(?=.*[A-Z])(?=.*\d).{6,}$", 
            ErrorMessage = "Password must be at least 6 characters, " +
            "at least 1 number, " +
            "and first letter uppercase.")]
        
        public string Password { get; set; }
        [DataType(DataType.Password)]
        [Compare(nameof(Password), ErrorMessage = "The password and confirmation password do not match.")]        
        public string RetypePassword { get; set; }

    }
}
