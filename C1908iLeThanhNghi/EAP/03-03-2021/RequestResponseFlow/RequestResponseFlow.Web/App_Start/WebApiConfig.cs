using System;
using System.Collections.Generic;
using System.Linq;
using System.Web.Http;
using RequestResponseFlow.Web.Extensions;

namespace RequestResponseFlow.Web
{
    public static class WebApiConfig
    {
        public static void Register(HttpConfiguration config)
        {
            //.../api/home/
            config.MessageHandlers.Add(new TraceHandler());//config as global

            config.MessageHandlers.Add(new TraceHandler());
            config.Routes.MapHttpRoute(
                name: "DefaultApi",
                routeTemplate: "api/{controller}/{id}",
                defaults: new { id = RouteParameter.Optional }
            );
        }
    }
}
