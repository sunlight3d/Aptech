using Microsoft.AspNetCore.Authorization;

namespace bai05.Filters
{
    public class RoleHandler : AuthorizationHandler<RoleRequirement>
    {
        protected override async Task HandleRequirementAsync(AuthorizationHandlerContext context, RoleRequirement requirement)
        {
            var requiredRole = requirement.Role;

            //custom auth logic
            //  you can use context to access authenticated user,
            //  you can use dependecy injection to call custom services 

            var hasRole = true;

            if (hasRole)
            {
                context.Succeed(requirement);
            }
            else
            {
                context.Fail(new AuthorizationFailureReason(this, $"Role {requirement.Role} missing"));
            }
        }
    }
}
