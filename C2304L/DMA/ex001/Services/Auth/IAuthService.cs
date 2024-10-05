using ex001.Dtos.Requests.User;
using ex001.Dtos.Responses;

namespace ex001.Services.Auth
{
    public interface IAuthService
    {
        Task<UserResponse> RegisterUser(RegisterUserRequest request);
        Task<string> AuthenticateUser(LoginUserRequest request);

        Task<UserResponse> GetUserById(int id);

    }

}
