using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EAP_C2009G_NguyenVanA.Startup))]
namespace EAP_C2009G_NguyenVanA
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
