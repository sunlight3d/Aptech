using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Security.Cryptography;
using System.Threading.Tasks;
using IdentityExample.Secure;
using Microsoft.AspNetCore;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.Logging;

namespace IdentityExample
{
    public class Program
    {
        public static void Main(string[] args)
        {
            string text = "123456";
            RSA rsa = RSA.Create();
            string encryptedText = AsymmetricEncryption.Encrypt(text, rsa);
            string decryptedText = AsymmetricEncryption.Decrypt(encryptedText, rsa);
            Console.WriteLine("haha");
            CreateWebHostBuilder(args).Build().Run();
            //Test secure password
            
        }

        public static IWebHostBuilder CreateWebHostBuilder(string[] args) =>
            WebHost.CreateDefaultBuilder(args)
                .UseStartup<Startup>();
    }
}
