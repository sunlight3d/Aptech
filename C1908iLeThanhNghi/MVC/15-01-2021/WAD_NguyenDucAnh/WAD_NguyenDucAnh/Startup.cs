using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(WAD_NguyenDucAnh.Startup))]
namespace WAD_NguyenDucAnh
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
