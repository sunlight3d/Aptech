using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;
namespace BusOnlineTicket.Models
{
    public class MyDbContext : DbContext
    {
        public DbSet<Bus> Buses { get; set; }
        public DbSet<Route> Routes { get; set; }
        public DbSet<Schedule> Schedules { get; set; }
        public DbSet<Employee> Employees { get; set; }
        public DbSet<Ticket> Tickets { get; set; }
        public DbSet<TicketPrice> TicketPrices { get; set; }
        public DbSet<Customer> Customers { get; set; }

        public MyDbContext(DbContextOptions<MyDbContext> options) : base(options)
        {
        }
    }
}
