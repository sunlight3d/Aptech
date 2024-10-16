using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Cryptography;
using System.Text;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;

namespace IdentityExample.Secure
{
    public class AsymmetricEncryption
    {
        public static string Encrypt(string text, RSA rsa)
        {            
            byte[] data = Encoding.UTF8.GetBytes(text);
            byte[] cipherText = rsa.Encrypt(data, RSAEncryptionPadding.Pkcs1);
            return Convert.ToBase64String(cipherText);
        }

        public static string Decrypt(string text, RSA rsa)
        {        
            byte[] data = Convert.FromBase64String(text);
            byte[] cipherText = rsa.Decrypt(data, RSAEncryptionPadding.Pkcs1);
            return Encoding.UTF8.GetString(cipherText);
        }

    }
}
