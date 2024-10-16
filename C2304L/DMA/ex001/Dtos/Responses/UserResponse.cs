using System.ComponentModel.DataAnnotations;
using ex001.Models;
namespace ex001.Dtos.Responses
{
    public class UserResponse
    {
        public int Id { get; set; }
        public string Email { get; set; }
        public string FullName { get; set; }
        public string Role { get; set; }
        public static UserResponse FromUser(User user) {
            return new UserResponse
            {
                Id = user.Id,
                Email = user.Email,
                FullName = user.FullName,
                Role = user.Role,
            };
        }

    }
}
