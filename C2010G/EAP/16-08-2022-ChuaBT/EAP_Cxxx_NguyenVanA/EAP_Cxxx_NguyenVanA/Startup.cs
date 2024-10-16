using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(EAP_Cxxx_NguyenVanA.Startup))]
namespace EAP_Cxxx_NguyenVanA
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
