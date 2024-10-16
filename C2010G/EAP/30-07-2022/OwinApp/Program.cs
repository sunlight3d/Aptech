using Microsoft.Owin.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace OwinApp
{
    internal class Program
    {
        static string BASE_URL = "http://localhost:9000/";
        static void Main(string[] args)
        {
            using (WebApp.Start<Startup>(url: BASE_URL)) {
                Console.WriteLine("Server started");
                Console.ReadLine();
            }
            //Example
            //http://localhost:9000/api/Product           
        }
    }
}
