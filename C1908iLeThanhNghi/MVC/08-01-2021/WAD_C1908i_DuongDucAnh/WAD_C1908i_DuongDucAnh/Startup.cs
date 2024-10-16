using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(WAD_C1908i_DuongDucAnh.Startup))]
namespace WAD_C1908i_DuongDucAnh
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
