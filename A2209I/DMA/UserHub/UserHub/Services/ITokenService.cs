using UserHub.DTOs.Responses;

namespace UserHub.Services
{
    public interface ITokenService
    {
        UserResponse? GetUserFromTokenHeaders(HttpContext httpContext);
    }

}
