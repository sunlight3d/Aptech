using DipplomaApp.Repositories;
using DipplomaAppClient.Models;
using Newtonsoft.Json;
using System;
using System.Text.Json;

namespace DiplomaAppClient.Repositories
{
    public class UserRepository : IUserRepository
    {
        private readonly string urlLogin = "https://localhost:7044/api/users/CheckLogin";
        public async Task<User> Login(string username, string password)
        {
            //call api
            string jsonString = await Api.SendPostRequestAsync(urlLogin, new Dictionary<string, string>
            {
                { "username", username },
                { "password", password }
            });
            var xx = JsonConvert.DeserializeObject<User>(jsonString);
            return JsonConvert.DeserializeObject<User>(jsonString);            
        }
    }
}
