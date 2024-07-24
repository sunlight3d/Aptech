using UserHub.Services;

namespace UserHub.Middlewares
{

    public class JwtMiddleware
    {
        private readonly RequestDelegate _next;

        public JwtMiddleware(RequestDelegate next)
        {
            _next = next;
        }

        public async Task Invoke(HttpContext context, ITokenService tokenService, IAuthService authService)
        {            
            var userResponse = tokenService.GetUserFromTokenHeaders(context);
            if (userResponse != null)
            {
                // attach user to context on successful jwt validation
                context.Items["UserId"] = userResponse;
            }

            await _next(context);
        }
    }
}
