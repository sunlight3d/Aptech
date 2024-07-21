using Microsoft.EntityFrameworkCore;
using UserHub.DTOs.Responses;
using UserHub.Models;

namespace UserHub.Services
{
    public interface IAuthService
    {
        Task<UserResponse> RegisterUser(string email, string password, string fullName);
        Task<string> AuthenticateUser(string email, string password);

        Task<UserResponse> GetUserById(int id);
        
    }

}
