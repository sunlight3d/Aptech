using Microsoft.AspNetCore.Authorization;
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

        protected override Task HandleRequirementAsync(
            AuthorizationHandlerContext context, LoginRequirement requirement)
        {
            //can I inject TokenService here, then get jwttoken from http context
            //or can I get httpcontext here 
            //Console.WriteLine("aa");
            var httpContext = _httpContextAccessor.HttpContext;
            var userResponse = _tokenService.GetUserFromTokenHeaders(httpContext);
            if (userResponse != null)
            {
                context.Succeed(requirement);
            }

            return Task.CompletedTask;
        }
        
    }
}
