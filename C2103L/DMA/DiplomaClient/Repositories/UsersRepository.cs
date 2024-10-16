using DiplomaClient.Controllers;
using DiplomaClient.Models;
using Newtonsoft.Json;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Security.Policy;
using System.Web;
using System.Web.UI.WebControls;

namespace DiplomaClient.Repositories
{
    public class UsersRepository
    {
        public User Login(string username, string password) {
            string jsonString = Api.SendRequest(Api.urlLogin(username, password), "", "POST");
            Dictionary<string, string> dictionary = JsonConvert
                .DeserializeObject<Dictionary<string, string>>(jsonString);
            //something more ...
            return User.FromJSON(dictionary);            
        }
        public List<User> GetUsers() {
            //send get API
            string jsonString = Api.SendRequest(Api.urlGetUsers(), "", "GET");
            List<Dictionary<string, string>> dictionary = JsonConvert
                .DeserializeObject<List<Dictionary<string, string>>>(jsonString);

            Console.WriteLine("haha");
            return new List<User>();
        }
    }
}