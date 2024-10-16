using System.ComponentModel.DataAnnotations;

namespace de11.ViewModels
{
    public class RegisterViewModel
    {
        [Required]
        [EmailAddress(ErrorMessage ="Email chưa đúng định dạng")]
        public string Email { get; set; }

        [Required]
        [StringLength(50, MinimumLength = 3, ErrorMessage ="Username từ 3 đến 50 ký tự")]
        public string UserName { get; set; }

        [Required]
        [MinLength(3)]
        public string Password { get; set; }

        [Required]
        [Compare(nameof(Password))]
        public string RetypePassword { get; set; }
    }
}
