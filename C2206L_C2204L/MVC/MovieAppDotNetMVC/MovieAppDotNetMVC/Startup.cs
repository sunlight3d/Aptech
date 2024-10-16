using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(MovieAppDotNetMVC.Startup))]
namespace MovieAppDotNetMVC
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
