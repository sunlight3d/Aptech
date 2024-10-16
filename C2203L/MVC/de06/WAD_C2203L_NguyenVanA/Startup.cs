using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(WAD_C2203L_NguyenVanA.Startup))]
namespace WAD_C2203L_NguyenVanA
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
/*
 Write model classes, Data Context(using Entity Framework) for these entities:
Project entity:
ProjectId
ProjectName
ProjectStartDate
ProjectEndDate

Employee Entity:
EmployeeId
EmployeeName
EmployeeDOB
EmployeeDepartment

Project / Employee relation is n - n

ProjectEmployee Entity:
EmployeeId
ProjectId
Tasks

create DataInitializer  inheriting from the class DropCreateDatabaseIfModelChanges<DataContext>
to create some fake data, execute in Global.asax
I use .net MVC, not .net core





 */
