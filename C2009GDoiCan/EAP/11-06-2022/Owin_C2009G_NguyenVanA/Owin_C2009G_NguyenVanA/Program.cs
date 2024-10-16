using Microsoft.Owin.Hosting;
using Newtonsoft.Json;
using Owin;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2009G_NguyenVanA
{
    class Program
    {
        private static void Get(string url) {
            HttpClient client = new HttpClient();

            var response = client.GetAsync(url).Result;

            Console.WriteLine(response);
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);
            Console.ReadLine();
        }
        private static void Post(string url, Album album)
        {
            HttpClient client = new HttpClient();

            HttpContent content = new 
                StringContent(JsonConvert.SerializeObject(album), 
                System.Text.Encoding.UTF8, "application/json");
            var response = client.PostAsync(url, content).Result;

            Console.WriteLine(response);
            Console.WriteLine(response.Content.ReadAsStringAsync().Result);
            Console.ReadLine();
        }
        static void Main(string[] args)
        {
            string baseAddress = "http://localhost:9000/";

            // Start OWIN host 
            using (WebApp.Start<Startup>(url: baseAddress))
            {
                // Create HttpClient and make a request to api/values 
                string url = baseAddress + "api/album";
                /*
                Post(url, new Album
                {
                    Title = "newwwwww",
                    Genre = "vien tuong",
                    Price = 11.22f
                });
                */
                Get(url);
            }
        }
        
    }
}
