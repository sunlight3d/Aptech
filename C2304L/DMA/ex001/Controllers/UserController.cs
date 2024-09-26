using ex001.Dtos.Requests.User;
using ex001.Dtos.Responses;
using ex001.Utilities;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using ex001.Models;

namespace ex001.Controllers
{
    [Route("api/[controller]s")]
    [ApiController]
    public class UserController : ControllerBase
    {
        [HttpPost("register")]
        public IActionResult Register([FromBody] RegisterUserRequest request)
        {
            // Check if the model is valid
            if (!ModelState.IsValid)
            {
                return BadRequest(ModelState); // Return validation errors
            }
            //call services: Servicename.ServiceFunction(request)
            // convert from Model to Response, eg: User => UserResponse
            //khi nao dung data mapper
            UserResponse response = new UserResponse
            {
                Email = request.Email,
                FullName = request.FullName,//duoi client gui len la full_name
                Id = 123 // Assign a proper ID
            };

            return Ok(response); // Return success response
        }
        [HttpGet("doSomething")]
        public IActionResult doSomething()
        {
            //string hashedPasswod = _passwordHasher.HashPassword("1234567");
            User testUser = new User() { 
                Id = 1,
                Email = "aaa@gmail.com",
            };
            testUser.Password = "123456";
            testUser.IsMatch("123456");
            return Ok(testUser.Password); // Return success response
        }
    }
}
