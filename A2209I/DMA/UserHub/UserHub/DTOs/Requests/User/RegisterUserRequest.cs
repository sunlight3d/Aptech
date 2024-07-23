using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;
namespace UserHub.DTOs.Requests.User
{

    public class RegisterUserRequest
    {
        [Required(ErrorMessage = "Email is required")]
        [EmailAddress(ErrorMessage = "A valid email is required")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Password is required")]
        [StringLength(100, ErrorMessage = "Password must be at least 6 characters long.", MinimumLength = 6)]
        public string Password { get; set; }

        [Required(ErrorMessage = "Full name is required")]
        [StringLength(100, ErrorMessage = "Full name must not exceed 100 characters")]
        [JsonPropertyName("fullname")]
        public string FullName { get; set; }

        [Required(ErrorMessage = "You must provide a phone number")]
        [DataType(DataType.PhoneNumber)]
        [StringLength(100)]
        [JsonPropertyName("phone_number")]
        public string PhoneNumber { get; set; }
    }

}
