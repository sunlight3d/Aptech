using ex001.Dtos.Responses;

namespace ex001.Services.Token
{
    public interface ITokenService
    {
        Task<UserResponse?> GetUserFromTokenHeaders(HttpContext httpContext);
    }
}
