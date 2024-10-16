using DiplomaClient.Models;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Security.Cryptography.X509Certificates;
using System.Text;
using System.Web;
using static System.Net.WebRequestMethods;

namespace DiplomaClient.Controllers
{
    public class Api
    {
        private const string SERVER_NAME = "localhost";
        private const string PORT = "44315";
        public static string urlLogin(string username, string password) 
                => $"https://{SERVER_NAME}:{PORT}/api/Users/CheckLogin?UserName={username}&Password={password}";
        public static string urlGetUsers() =>
            $"https://{SERVER_NAME}:{PORT}/api/Users";
        
        public static string SendRequest(string url, string postData, string method)
        {
            WebRequest request = WebRequest.Create(url);
            request.Method = method;
            if (method.ToLower().Equals("post"))
            {
                byte[] byteArray = Encoding.UTF8.GetBytes(postData);
                //request.ContentType = "application/x-www-form-urlencoded";
                request.ContentType = "application/json";
                request.ContentLength = byteArray.Length;
                Stream dataStream = request.GetRequestStream();
                dataStream.Write(byteArray, 0, byteArray.Length);
                dataStream.Close();
                WebResponse response = request.GetResponse();
                dataStream = response.GetResponseStream();
                StreamReader reader = new StreamReader(dataStream);
                string responseFromServer = reader.ReadToEnd();
                reader.Close();
                dataStream.Close();
                response.Close();
                return responseFromServer;
            }
            else 
            {
                using (var client = new HttpClient())
                {
                    client.BaseAddress = new Uri(url);
                    //HTTP GET
                    var responseTask = client.GetAsync(url);
                    responseTask.Wait();

                    var result = responseTask.Result;
                    if (result.IsSuccessStatusCode)
                    {
                        var readTask = result.Content.ReadAsStringAsync();
                        readTask.Wait();

                        return readTask.Result;
                    }
                    else //web api sent error response 
                    {
                          return "";
                    }
                }
            }
            
        }        
    }
}