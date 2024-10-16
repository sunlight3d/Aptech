using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Web;

namespace DiplomaClient.Models
{
    public class User
    {
        public int UsersID { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
        public string Discription { get; set; }
        //Factory method
        public static User FromJSON(Dictionary<string, string> dictionary) => 
            new User
            {
                UserName = dictionary["UserName"] ?? "",
                UsersID = int.Parse(dictionary["UsersID"]),
                Discription = dictionary["Discription"],
            };                    
    }
}