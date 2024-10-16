using _03_07_2023.DTOs;
using Microsoft.AspNetCore.Mvc;

namespace _03_07_2023.Controllers
{
    public class UserController : Controller
    {

        public IActionResult Index()
        {
            return View();
        }
        //trang Register
        [HttpGet]
        public IActionResult Register() {
            //tạo ra một đối tượng Request trống
            UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
            return View(userRegisterRequest);//Views/User/Register.cshtml
            //Hai cú pháp trong cshtml: HtmlHelper(old), Tag Helper(mới)
        }
        [HttpPost]
        public IActionResult Register(UserRegisterRequest userRegisterRequest) {
            //nghiệp vụ thêm dữ liệu xuống DB
            Console.WriteLine("Haha");
            //userRegisterRequest đã được 2-way data binding
            //Làm thế nào để validate được: Email đúng định dạng, FullName tối thiểu 3 ký tự
            //Password phải > 3 ký tự
            //ko dùng if-else từng trường =>dùng Model Validation
            //cách truyền thống?
            //if(userRegisterRequest.FullName.Length > 3) .... => 
            //2 pass phải giống nhau => Custom Validation
            if (!ModelState.IsValid)
            {
                return View(userRegisterRequest);//đứng im tại chỗ và báo lỗi
            }
            //đoạn này nhảy vào khi validate thành công
            //cụ thể: insert vào db, mã hóa mật khẩu,...
            //Entity Framework, NOT ADO.NET 
            return RedirectToAction("Index", "Home");//Chuyển sang action Index Của HomeController
        }
    }
}
