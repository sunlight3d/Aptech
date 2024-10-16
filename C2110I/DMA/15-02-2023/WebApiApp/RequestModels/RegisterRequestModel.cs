using System.ComponentModel.DataAnnotations;

namespace WebApiApp.RequestModels
{
    public class RegisterRequestModel
    {
        [Required]
        [EmailAddress]
        public string Email { get; set; }

        [Required]
        [MinLength(6)]
        public string Password { get; set; }

        public string? FullName { get; set; }
    }
}
