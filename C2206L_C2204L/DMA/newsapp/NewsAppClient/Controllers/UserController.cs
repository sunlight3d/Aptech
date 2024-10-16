using Microsoft.AspNetCore.Mvc;
using NewsAppClient.Models;
using Newtonsoft.Json;
using Newtonsoft.Json.Linq;
using System.Diagnostics;
using System.Net.Http;

namespace NewsAppClient.Controllers
{
    public class UserController : Controller
    {
        private readonly ILogger<UserController> _logger;
        private readonly IHttpClientFactory _httpClientFactory;        
        private String urlLogin = "https://localhost:7175/api/User/CheckLogin";
        private String urlUsers = "https://localhost:7175/api/User";

        public UserController(ILogger<UserController> logger, IHttpClientFactory httpClientFactory)
        {
            _logger = logger;
            _httpClientFactory = httpClientFactory;
        }

        public IActionResult Index()
        {
            ViewBag.UserName = HttpContext.Session.GetString("UserName") ?? "";
            ViewBag.Password = HttpContext.Session.GetString("Password") ?? "";
            return View();//Views/Index.cshtml
        }

        public async Task<IActionResult> GetAllUsers()
        {
            try
            {
                var users = await GetUsersFromApi();
                return View(users);
            }
            catch (Exception ex)
            {
                // Handle exception here.
                return View(new List<User>());
            }
        }

        private async Task<List<User>> GetUsersFromApi()
        {
            var client = _httpClientFactory.CreateClient();
            var response = await client.GetAsync(this.urlUsers);

            if (response.IsSuccessStatusCode)
            {
                var jsonString = await response.Content.ReadAsStringAsync();
                List<User> users = JsonConvert.DeserializeObject<List<User>>(jsonString);
                return users;
            }
            else
            {
                // Handle error response here if needed.
                return new List<User>();
            }
        }

        public async Task<IActionResult> Login(string UserName, string Password, string RememberPassword)
        {
            //call api
            if (RememberPassword != null) {
                HttpContext.Session.SetString("UserName", UserName);
                HttpContext.Session.SetString("Password", Password);                
            }
            var client = _httpClientFactory.CreateClient();

            var content = new StringContent("", System.Text.Encoding.UTF8, "text/plain");            
            var response = await client.PostAsync($"{urlLogin}?userName={UserName}&password={Password}", content);

            if (response.IsSuccessStatusCode) //check code is 200
            {
                //var responseContent = await response.Content.ReadAsStringAsync();

                //return Content(responseContent, "text/plain");
                return RedirectToAction("GetAllUsers");                
            }
            else { 

            }
            return View("Index");//Views/Index.cshtml
        }


        [HttpGet]        
        public async Task<IActionResult> Edit(int id)
        {
            try
            {
                User existingUser = await GetUserByIdAsync(id);

                if (existingUser != null)
                {
                    return View(existingUser);
                }
                else
                {
                    // Handle error response here if needed.
                    return View();
                }
            }
            catch (Exception ex)
            {
                // Handle exception here.
                return View();
            }
        }

        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Edit(int id, User editedUser)
        {
            try
            {
                User existingUser = await GetUserByIdAsync(id);

                if (existingUser != null)
                {
                    // Update properties of existingUser using data from editedUser
                    // For example: existingUser.Property = editedUser.Property;

                    var updatedJson = JsonConvert.SerializeObject(editedUser);
                    var content = new StringContent(updatedJson, System.Text.Encoding.UTF8, "application/json");

                    var updateResponse = await UpdateUserAsync(id, content);

                    if (updateResponse.IsSuccessStatusCode)
                    {
                        return RedirectToAction("GetAllUsers");
                    }
                }

                return View();
            }
            catch (Exception ex)
            {
                // Handle exception here.
                return View();
            }
        }

        private async Task<User> GetUserByIdAsync(int id)
        {
            var client = _httpClientFactory.CreateClient();
            var response = await client.GetAsync($"{this.urlUsers}/{id}");

            if (response.IsSuccessStatusCode)
            {
                var jsonString = await response.Content.ReadAsStringAsync();
                User existingUser = JsonConvert.DeserializeObject<User>(jsonString);
                return existingUser;
            }
            else
            {
                return null;
            }
        }

        private async Task<HttpResponseMessage> UpdateUserAsync(int id, HttpContent content)
        {
            var client = _httpClientFactory.CreateClient();
            var updateResponse = await client.PutAsync($"{this.urlUsers}/{id}", content);
            return updateResponse;
        }



        // POST: TempController/Delete/5
        [HttpPost]
        [ValidateAntiForgeryToken]
        public async Task<IActionResult> Delete(int id)
        {
            try
            {
                var client = _httpClientFactory.CreateClient();

                var response = await client.DeleteAsync($"{this.urlUsers}/{id}");

                if (response.IsSuccessStatusCode)
                {
                    return RedirectToAction("GetAllUsers");
                }

                return View();
            }
            catch (Exception ex)
            {
                // Handle exception here.
                return View();
            }
        }
    }
}