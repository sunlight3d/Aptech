using System;
using Microsoft.AspNetCore.Mvc;
using myapp.Controllers.Filters;

namespace myapp.Controllers.Attributes
{
    public class AuthorizeTokenAttribute : TypeFilterAttribute
    {
        public AuthorizeTokenAttribute() : base(typeof(TokenAuthorizationFilter))
        {
        }
    }
}

