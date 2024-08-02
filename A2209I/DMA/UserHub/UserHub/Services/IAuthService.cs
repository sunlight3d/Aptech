using Microsoft.EntityFrameworkCore;
using UserHub.DTOs.Requests.User;
using UserHub.DTOs.Responses;
using UserHub.Models;

namespace UserHub.Services
{
    public interface IAuthService
    {
        Task<UserResponse> RegisterUser(RegisterUserRequest request);
        Task<string> AuthenticateUser(LoginUserRequest request);

        Task<UserResponse> GetUserById(int id);
        
    }

}
