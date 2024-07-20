using UserHub.Models;

namespace UserHub.Services
{
    public interface IAuthService
    {
        Task<User> RegisterUser(string email, string password, string fullName);
        Task<string> AuthenticateUser(string email, string password);
    }

}
