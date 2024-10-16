using Microsoft.Owin.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Owin_C2009i_NguyenVanA
{
    internal class Program
    {
        static void Main(string[] args)
        {
            const string HOST = "localhost";
            const int PORT = 9000;
            //string baseAddress = $"http://{HOST}:{PORT}/";
            string baseAddress11 = "http://localhost:8080/";
            // Start OWIN host 
            using (WebApp.Start<Startup>(url: baseAddress11))
            {
                // Create HttpClient and make a request to api/values 
                HttpClient client = new HttpClient();

                var response = client.GetAsync(baseAddress11 + "api/album").Result;

                Console.WriteLine(response);
                Console.WriteLine(response.Content.ReadAsStringAsync().Result);
                Console.ReadLine();
            }
        }
    }
}
