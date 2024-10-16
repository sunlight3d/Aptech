using DipplomaAppClient.Models;

namespace DipplomaApp.Repositories
{
    public interface IUserRepository
    {
        Task<User> Login(string username, string password);        
    }
}
