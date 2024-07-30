using Microsoft.AspNetCore.SignalR;
using System.ComponentModel.DataAnnotations;
using UserHub.Models;

namespace UserHub.DTOs.Responses
{
    public class UserResponse
    {

        //convert User to UserResponse
        public int Id { get; set; }
        public string Email { get; set; }
        public string FullName { get; set; }
        public string PhoneNumber { get; set; }
        public string Role { get; set; }
        public static UserResponse FromUser(User user) {
            //Auto Mapper / Object Mapper
            return new UserResponse
            {
                Id = user.Id,
                Email = user.Email,
                FullName = user.FullName,
                PhoneNumber = user.PhoneNumber,
                Role = user.Role
            };
        }
    }
}
