namespace WAD_C2108G2_NguyenVanA.Migrations
{
    using System;
    using System.Data.Entity;
    using System.Data.Entity.Migrations;
    using System.Linq;
    using WAD_C2108G2_NguyenVanA.Models;

    internal sealed class Configuration : DbMigrationsConfiguration<WAD_C2108G2_NguyenVanA.Models.DataContext>
    {
        public Configuration()
        {
            AutomaticMigrationsEnabled = false;
        }

        protected override void Seed(WAD_C2108G2_NguyenVanA.Models.DataContext context)
        {
            //  This method will be called after migrating to the latest version.

            //  You can use the DbSet<T>.AddOrUpdate() helper extension method
            //  to avoid creating duplicate seed data.
            DataInitializer.SeedData(context);
        }
    }
}
