using System;
using System.Diagnostics;
using Microsoft.AspNetCore.Mvc;
using de01Client.Models;
using de01Client.ViewModels;
using Newtonsoft.Json;

namespace de01Client.Controllers
{
	public class UserController : Controller
    {
        private readonly ILogger<UserController> _logger;
        private readonly HttpClient _httpClient;
        public UserController(ILogger<UserController> logger, HttpClient httpClient)
		{
            _logger = logger;
            _httpClient = httpClient;
        }
        public async Task<IActionResult> Index()
        {
            string apiUrl = $"{Utilities.baseUrl}/User";
            HttpResponseMessage response = await _httpClient.GetAsync(apiUrl);
            if (response.IsSuccessStatusCode)
            {
                string responseString = await response.Content.ReadAsStringAsync();
                IEnumerable<User> users = JsonConvert.DeserializeObject<IEnumerable<User>>(responseString);
                return View(users);
            }
            return View(new List<User>());
        }

        [HttpPost]
        public async Task<IActionResult> Login(LoginViewModel loginViewModel)
        {
            if(!ModelState.IsValid)
            {
                throw new Exception("Invalid input");
            }
            var user = await CheckLogin(loginViewModel.UserName, loginViewModel.Password);
            if (user == null) {
                return View();
            }

            return RedirectToAction("Index", "Diploma");
        }
        public async Task<User?> CheckLogin(string userName, string password)
        {            
            string apiUrl = $"{Utilities.baseUrl}/User/CheckLogin?userName={userName}&password={password}";
            HttpResponseMessage response = await _httpClient.GetAsync(apiUrl);
            if (response.IsSuccessStatusCode)
            {
                string responseString = await response.Content.ReadAsStringAsync();
                User? user = JsonConvert.DeserializeObject<User>(responseString);
                return user;
            }
            return null;
        }
    }
}

