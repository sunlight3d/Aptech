using Microsoft.AspNetCore.Authorization;
using UserHub.DTOs.Responses;
using UserHub.Services;

namespace UserHub.Authorization
{
    public class LoginRequirement: IAuthorizationRequirement
    {

    }
    public class LoginRequirementHandler : AuthorizationHandler<LoginRequirement>
    {
        private readonly ITokenService _tokenService;
        private readonly IHttpContextAccessor _httpContextAccessor;

        public LoginRequirementHandler(ITokenService tokenService, IHttpContextAccessor httpContextAccessor)
        {
            _tokenService = tokenService;
            _httpContextAccessor = httpContextAccessor;
        }

        protected override async Task HandleRequirementAsync(
            AuthorizationHandlerContext context, LoginRequirement requirement)
        {
            HttpContext httpContext = _httpContextAccessor.HttpContext;

            // Use await to asynchronously get the UserResponse
            UserResponse? userResponse = await _tokenService.GetUserFromTokenHeaders(httpContext);

            // Store the user response in HttpContext items
            httpContext.Items["user"] = userResponse;

            // Check if userResponse is not null to decide if the requirement is met
            if (userResponse != null)
            {
                context.Succeed(requirement);
            }

            // No need to return anything; async Task methods complete upon reaching the end
        }


    }
}
