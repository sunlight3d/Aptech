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

        protected override async Task HandleRequirementAsync(
            AuthorizationHandlerContext context, AdminRequirement requirement)
        {
            HttpContext httpContext = _httpContextAccessor.HttpContext;

            // Use await to asynchronously get the UserResponse
            UserResponse? userResponse = await _tokenService.GetUserFromTokenHeaders(httpContext);

            // Check if userResponse is not null before accessing its properties
            if (userResponse != null)
            {
                httpContext.Items["UserId"] = userResponse.Id;

                // Check if the role is admin
                if (userResponse.Role.Trim().ToLower().Equals("admin"))
                {
                    context.Succeed(requirement);
                }
            }
        }


    }
}
