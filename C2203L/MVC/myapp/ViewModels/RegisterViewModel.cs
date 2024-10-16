using System.ComponentModel.DataAnnotations;

namespace myapp.ViewModels
{
    public class RegisterViewModel: LoginViewModel
    {
        [Required]
        [Compare(nameof(Password), ErrorMessage = "The password and confirmation password do not match.")]
        public string RetypePassword { get; set; }        
    }
}
