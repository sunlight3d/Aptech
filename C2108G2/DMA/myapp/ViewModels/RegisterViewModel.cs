using System.ComponentModel.DataAnnotations;

namespace myapp.ViewModels
{
    public class RegisterViewModel
    {
        [Required]
        [MaxLength(50)]
        public string Username { get; set; } = "";

        [Required]
        [MaxLength(255)]
        [EmailAddress]
        public string Email { get; set; } = "";

        [MaxLength(255)]
        public string Password { get; set; } = "";

        [Required]
        [MaxLength(20)]
        [Phone]
        public string Phone { get; set; } = "";

        [MaxLength(255)]
        public string FullName { get; set; } = "";

        public DateTime? DateOfBirth { get; set; }

        [MaxLength(255)]
        public string Country { get; set; } = "";
    }
}
