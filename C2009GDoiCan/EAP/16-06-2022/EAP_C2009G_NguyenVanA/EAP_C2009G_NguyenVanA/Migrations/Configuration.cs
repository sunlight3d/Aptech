namespace EAP_C2009G_NguyenVanA.Migrations
{
    using EAP_C2009G_NguyenVanA.Models;
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;

    internal sealed class Configuration : DbMigrationsConfiguration<EAP_C2009G_NguyenVanA.Models.DataContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(EAP_C2009G_NguyenVanA.Models.DataContext context)
        {
            //  This method will be called after migrating to the latest version.
            DataInitializer dataInitializer = new DataInitializer();
            dataInitializer.GenerateData(context);
            //  You can use the DbSet<T>.AddOrUpdate() helper extension method 
            //  to avoid creating duplicate seed data. E.g.
            //
            //    context.People.AddOrUpdate(
            //      p => p.FullName,
            //      new Person { FullName = "Andrew Peters" },
            //      new Person { FullName = "Brice Lambson" },
            //      new Person { FullName = "Rowan Miller" }
            //    );
            //
        }
    }
}
