using System.Security.Cryptography;
using System.Text;

namespace de11.Models
{
    public class User
    {
        public int Id { get; set; }
        public string UserName { get; set; }
        public string Email { get; set; }
        public string Password { get; set; }
        public static string ConvertToSha1(string text)
        {
            byte[] buffer = Encoding.UTF8.GetBytes(text);
            SHA1Managed sha1 = new SHA1Managed();
            var hash = sha1.ComputeHash(buffer);
            return Convert.ToBase64String(hash);
        }
        public static bool isMachedPassword(string rawPassword, string encryptedPassword) { 
            return ConvertToSha1(rawPassword).Equals(encryptedPassword);
        }
    }
}
/*
USE C2203L;
CREATE TABLE Users(
    Id INT PRIMARY KEY IDENTITY(1,1),
    UserName NVARCHAR(100),
    Email NVARCHAR(100) NOT NULL UNIQUE,
    PASSWORD NVARCHAR(100) NOT NULL    
);
 */