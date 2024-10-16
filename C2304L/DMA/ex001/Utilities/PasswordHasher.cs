namespace ex001.Utilities
{
    using System;
    using System.Security.Cryptography;

    public static class PasswordHasher
    {
        /// <summary>
        /// Hashes a password using PBKDF2 with a given salt.
        /// </summary>
        /// <param name="password">The plain text password to hash.</param>
        /// <param name="salt">The salt used for hashing, in Base64 string format.</param>
        /// <returns>The hashed password as a Base64 string.</returns>
        public static string HashPassword(string password)
        {
            using (var rfc2898DeriveBytes = new Rfc2898DeriveBytes(password, 
                Convert.FromBase64String(Environment.GetEnvironmentVariable("APP_SALT") ?? ""), 
                    10000, 
                    HashAlgorithmName.SHA512))
            {
                byte[] hashBytes = rfc2898DeriveBytes.GetBytes(32); // 32 bytes for the hash
                return Convert.ToBase64String(hashBytes);
            }
        }
    }

}
