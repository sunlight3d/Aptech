using UserHub.DTOs.Responses;

namespace UserHub.Services
{
    public interface ITokenService
    {
        Task<UserResponse?> GetUserFromTokenHeaders(HttpContext httpContext);
    }

}
