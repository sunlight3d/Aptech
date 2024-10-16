using System.ComponentModel.DataAnnotations;

namespace myapp.ViewModels
{
    public class LoginViewModel
    {
        [Required]
        [EmailAddress]
        public string Email { get; set; } = "";
        [Required]
        public string Password { get; set; } = "";
        [Required]
        public string DeviceId { get; set; } = "";
    }
}
