using System.ComponentModel.DataAnnotations;

namespace ex001.Dtos.Responses
{
    public class UserResponse
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string FullName { get; set; }

    }
}
