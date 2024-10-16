using System.Security.Cryptography;
using System.Text;

namespace ECommerceApp.Utilities
{
    public class Helper
    {
        public static string EncryptPassword(string password) {
            byte[] inputBytes = Encoding.UTF8.GetBytes(password);

            using (SHA512 sha512 = SHA512.Create())
            {
                byte[] hashBytes = sha512.ComputeHash(inputBytes);

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < hashBytes.Length; i++)
                {
                    sb.Append(hashBytes[i].ToString("X2"));
                }

                return sb.ToString();
            }
            return "";
        }
        public bool CheckPassword(string password, string encryptedPassword) {
            return encryptedPassword.Equals(EncryptPassword(password));
        }
    }
}
