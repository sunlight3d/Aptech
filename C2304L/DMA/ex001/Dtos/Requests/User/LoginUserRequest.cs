using System.ComponentModel.DataAnnotations;
using System.Text.Json.Serialization;

namespace ex001.Dtos.Requests.User
{
    public class LoginUserRequest
    {
        [EmailAddress(ErrorMessage = "Type must be a valid email")]
        [JsonPropertyName("email")]
        public string Email { get; set; }

        //Hai trường Password và RetypePassword có thể null, nếu khác null thì mới check độ dài và check nội dung
        [MinLength(6, ErrorMessage = "Password must be at least 6 characters long")]
        public string Password { get; set; }
    }

}
