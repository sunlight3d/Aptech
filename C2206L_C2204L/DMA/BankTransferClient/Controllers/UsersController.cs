using BankTransferClient.dtos;
using BankTransferClient.Models;
using Microsoft.AspNetCore.Mvc;
using System.Text.Json;

namespace BankTransferClient.Controllers
{
    public class UsersController : Controller
    {
        private readonly HttpClient _httpClient;
        
        public UsersController(IHttpClientFactory httpClientFactory)
        {
            _httpClient = httpClientFactory.CreateClient();
            // Đặt cấu hình cần thiết cho _httpClient, ví dụ đặt base address của API.
            _httpClient.BaseAddress = new Uri("https://localhost:1234");
        }
        public IActionResult Login()
        {
            return View();
        }

        public async Task<IActionResult> Login(LoginDTO loginModel)
        {
            // Gửi yêu cầu POST đến API để xác thực
            var request = new HttpRequestMessage(HttpMethod.Post, "api/users");
            request.Content = new FormUrlEncodedContent(new[]
            {
            new KeyValuePair<string, string>("username", loginModel.Username),
            new KeyValuePair<string, string>("password", loginModel.Password)
        });

            var response = await _httpClient.SendAsync(request);

            if (response.IsSuccessStatusCode)
            {
                // Xác thực thành công, chuyển hướng đến action BankTransfer
                return RedirectToAction("BankTransfer");
            }
            else
            {
                // Xác thực không thành công, hiển thị lại trang đăng nhập với thông báo lỗi
                ModelState.AddModelError(string.Empty, "Invalid login attempt. Please try again.");
                return View(loginModel);
            }
        }


        public async Task<IActionResult> BankTransfer()
        {
            // Gọi API để lấy thông tin người gửi và người nhận
            int senderId = 1; // Thay đổi senderId tùy theo người dùng hiện tại
            int receiverId = 2; // Thay đổi receiverId tùy theo người dùng hiện tại

            User sender = await GetUserInfo(senderId);
            User receiver = await GetUserInfo(receiverId);

            // Lưu thông tin vào ViewBag
            ViewBag.Sender = sender;
            ViewBag.Receiver = receiver;

            return View();
        }

        private async Task<User> GetUserInfo(int userId)
        {
            // Gọi API để lấy thông tin của User từ userId
            // Sử dụng HttpClient để thực hiện cuộc gọi API tại đây
            // Ví dụ:
                       
            var request = new HttpRequestMessage(HttpMethod.Post, "api/GetUsersInfor");

            var response = await _httpClient.SendAsync(request);            

            if (response.IsSuccessStatusCode)
            {
                var jsonString = await response.Content.ReadAsStringAsync();
                User user = JsonSerializer.Deserialize<User>(jsonString);                
                return user;
            }
            else
            {
                // Xử lý lỗi hoặc trả về một User mặc định nếu không thành công
                return new User();
            }
        }

    }
}
