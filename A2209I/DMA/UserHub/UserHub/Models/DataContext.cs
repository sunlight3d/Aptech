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
        public DbSet<BlogImage> BlogImages { get; set; }
        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
        }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Configure the one-to-many relationship between User and Post
            modelBuilder.Entity<User>()
                .HasMany(u => u.Posts)      // A User has many Posts
                .WithOne(p => p.User)       // Each Post has one User
                .HasForeignKey(p => p.UserId)  // The foreign key in the Post table is UserId
                .OnDelete(DeleteBehavior.Cascade);  // Cascade delete posts when user is deleted

            // Configure the one-to-many relationship between Post and Image
            modelBuilder.Entity<Post>()
                .HasMany(p => p.BlogImages)     // A Post has many Images
                .WithOne(i => i.Post)       // Each Image is associated with one Post
                .HasForeignKey(i => i.BlogId)  // The foreign key in the Image table is BlogId
                .OnDelete(DeleteBehavior.Cascade);  // Cascade delete images when post is deleted
            modelBuilder.Entity<Post>()
               .HasIndex(p => p.Title)
               .IsUnique();
        }



    }

}
