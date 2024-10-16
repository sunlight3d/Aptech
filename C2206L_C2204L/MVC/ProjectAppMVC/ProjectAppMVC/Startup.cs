/*
enable-migrations
add-migration CreateTableAndData
update-database -verbose
Neu ko ok thi phai xoa migration lam lai
Update-Database -TargetMigration $InitialDatabase
 */

using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(ProjectAppMVC.Startup))]
namespace ProjectAppMVC
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
