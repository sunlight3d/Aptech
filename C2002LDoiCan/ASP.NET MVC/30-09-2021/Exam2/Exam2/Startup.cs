using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Exam2.Startup))]
namespace Exam2
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
