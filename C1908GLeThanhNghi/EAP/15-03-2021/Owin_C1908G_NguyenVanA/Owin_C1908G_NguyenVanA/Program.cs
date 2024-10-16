using Microsoft.Owin.Hosting;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Owin_C1908G_NguyenVanA
{
    class Program
    {
        static void Main(string[] args)
        {
            const string SERVER_NAME = "localhost";
            const string PORT = "9000";
            string baseAddress = $"http://{SERVER_NAME}:{PORT}/";

            // Start OWIN host 
            using (WebApp.Start<Startup>(url: baseAddress))
            {
                // Create HttpClient and make a request to api/values 
                /*
                HttpClient client = new HttpClient();

                var response = client.GetAsync(baseAddress + "api/song").Result;
                Console.WriteLine(response);
                Console.WriteLine(response.Content.ReadAsStringAsync().Result);
                */
                Console.WriteLine($"SERVER is running on port : {PORT}");
                Console.ReadLine();
            }
        }
    }
}
