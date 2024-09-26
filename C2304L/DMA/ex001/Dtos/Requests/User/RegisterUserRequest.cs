using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace ex001.Dtos.Requests.User
{
    
    public class RegisterUserRequest : IValidatableObject
    {
        [Required]
        [EmailAddress(ErrorMessage = "Type must be a valid email")]
        public string Email { get; set; }

        [Required]
        [MinLength(5, ErrorMessage = "FullName must be at least 5 characters long")]
        [JsonPropertyName("full_name")]
        public string FullName { get; set; }

        //Hai trường Password và RetypePassword có thể null, nếu khác null thì mới check độ dài và check nội dung
        [MinLength(6, ErrorMessage = "Password must be at least 6 characters long")]
        public string Password { get; set; }

        [Compare("Password", ErrorMessage = "Password and RetypePassword must be the same")]
        [JsonPropertyName("retype_password")]
        public string RetypePassword { get; set; }
        //public AddressRequest Address { get; set; }

        public IEnumerable<ValidationResult> Validate(ValidationContext validationContext)
        {
            // Check if Password is not null, then check MinLength
            if (!string.IsNullOrEmpty(Password) && Password.Length < 6)
            {
                yield return new ValidationResult("Password must be at least 6 characters long", new[] { nameof(Password) });
            }

            // Check if RetypePassword matches Password if both are not null
            if (!string.IsNullOrEmpty(Password) && !string.IsNullOrEmpty(RetypePassword) && Password != RetypePassword)
            {
                yield return new ValidationResult("Password and RetypePassword must be the same", new[] { nameof(RetypePassword) });
            }
        }
    }

}
