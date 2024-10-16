using DAL.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace DAL.Database
{
    public class MyDbContext : DbContext
    {
        public DbSet<Traveler> Travelers { get; set; }
        public DbSet<Room> Rooms { get; set; }
        public DbSet<Booking> Bookings { get; set; }
        public DbSet<Hotel> Hotels { get; set; }

        private void InitialDBContext()
        {
            DbInitializer.Initialize(this);
        }

        // Default Constructor
        public MyDbContext()
        {
            InitialDBContext();
        }

        // Constructor with options
        public MyDbContext(DbContextOptions<MyDbContext> options)
                : base(options)
        {
            InitialDBContext();
        }

        protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
        {
            if (!optionsBuilder.IsConfigured)
            {
                //


                var sql = "Server=DESKTOP-7PS7HG8\\SQLEXPRESS;Database=C1908iLTN; User Id=sa;Password=123456;MultipleActiveResultSets=true";
                //optionsBuilder.UseSqlServer(@"Server=.\SQLEXPRESS;Database=Mod2Lab1DB;Trusted_Connection=True;");
                optionsBuilder.UseSqlServer(sql);
            }
        }
    }
}
