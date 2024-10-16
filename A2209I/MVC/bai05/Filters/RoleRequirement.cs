using Microsoft.AspNetCore.Authorization;

namespace bai05.Filters
{
    public class RoleRequirement : IAuthorizationRequirement
    {
        public string Role { get; set; }
    }
}
