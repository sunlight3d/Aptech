using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;
/*
 * 
 */
namespace UserHub.Models
{
    public class DataContext : DbContext
    {
        
        public DbSet<User> Users { get; set; }
        public DbSet<Post> Posts { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Configure the one-to-many relationship
            modelBuilder.Entity<User>()
                .HasMany(u => u.Posts)
                .WithOne(p => p.User)
                .HasForeignKey(p => p.UserId);
        }
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
        }

    }

}
