using BlueYonder.Flights.Models;
using Microsoft.EntityFrameworkCore;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace BlueYonder.Flights.Database
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
                optionsBuilder.UseSqlServer(@"Server=DESKTOP-7PS7HG8\SQLEXPRESS;Database=C1908iLTN;User Id=sa; Password=123456;Trusted_Connection=True;");
                //optionsBuilder.UseSqlServer(@"Server=(localdb)\\mssqllocaldb;Database=FlightDB;Trusted_Connection=True;MultipleActiveResultSets=true");
                
            }
        }
    }
}
