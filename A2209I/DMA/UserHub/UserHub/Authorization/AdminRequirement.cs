using Microsoft.AspNetCore.Authorization;
using UserHub.DTOs.Responses;
using UserHub.Services;

namespace UserHub.Authorization
{
    public class AdminRequirement : IAuthorizationRequirement
    {

    }
    public class AdminRequirementHandler : AuthorizationHandler<AdminRequirement>
    {
        private readonly ITokenService _tokenService;
        private readonly IHttpContextAccessor _httpContextAccessor;

        public AdminRequirementHandler(ITokenService tokenService, IHttpContextAccessor httpContextAccessor)
        {
            _tokenService = tokenService;
            _httpContextAccessor = httpContextAccessor;
        }

        protected override Task HandleRequirementAsync(
            AuthorizationHandlerContext context, AdminRequirement requirement)
        {
            HttpContext httpContext = _httpContextAccessor.HttpContext;
            UserResponse userResponse =  _tokenService.GetUserFromTokenHeaders(httpContext);
            httpContext.Items["UserId"] = userResponse.Id;
            if (userResponse != null && userResponse.Role.Trim().ToLower().Equals("admin"))
            {
                context.Succeed(requirement);
            }

            return Task.CompletedTask;
        }

    }
}
