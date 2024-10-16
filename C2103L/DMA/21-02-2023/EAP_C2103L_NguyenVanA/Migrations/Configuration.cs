namespace EAP_C2103L_NguyenVanA.Migrations
{
    using EAP_C2103L_NguyenVanA.Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<EAP_C2103L_NguyenVanA.Models.DataContext>
    {
        public Configuration()
        {            
            AutomaticMigrationsEnabled = true;
        }

        protected override void Seed(EAP_C2103L_NguyenVanA.Models.DataContext context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method
            //  to avoid creating duplicate seed data.
            //Database.SetInitializer(new DbInitializer());
            DbInitializer.InitData(context);

        }
    }
}
