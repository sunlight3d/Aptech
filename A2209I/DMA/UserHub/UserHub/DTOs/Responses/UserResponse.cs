using Microsoft.AspNetCore.SignalR;
using System.ComponentModel.DataAnnotations;
using UserHub.Models;

namespace UserHub.DTOs.Responses
{
    public class UserResponse
    {

        //convert User to UserResponse
        public int UserId { get; set; }
        public string Email { get; set; }
        public string FullName { get; set; }
        public static UserResponse FromUser(User user) {
            //Auto Mapper / Object Mapper
            return new UserResponse
            {
                UserId = user.UserId,
                Email = user.Email,
                FullName = user.FullName,
            };
        }
    }
}
