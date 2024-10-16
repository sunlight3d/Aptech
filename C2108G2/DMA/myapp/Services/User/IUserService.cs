using System;
using myapp.Models;
using myapp.ViewModels;

namespace myapp.Services
{
    public interface IUserService
    {
        Task<string> Authenticate(LoginViewModel loginViewModel);
        Task<User?> Register(RegisterViewModel registerViewModel);
        Task<User?> GetUserById(int id);
    }
}

