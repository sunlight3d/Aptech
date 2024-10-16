using Microsoft.EntityFrameworkCore;
using System.Collections.Generic;

namespace ex003.Models
{
    public class DataContext : DbContext
    {
        public DbSet<Artist> Artists { get; set; }
        public DbSet<Artwork> Artworks { get; set; }

        public DataContext(DbContextOptions<DataContext> options) : base(options)
        {
        }
        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

            // Configure the one-to-many relationship between User and Post
            modelBuilder.Entity<Artist>()
                .HasMany(artist => artist.Artworks)      // A User has many Posts
                .WithOne(artwork => artwork.Artist)       // Each Post has one User
                .HasForeignKey(artwork => artwork.ArtistId)  // The foreign key in the Post table is UserId
                .OnDelete(DeleteBehavior.Cascade);  // Cascade delete posts when user is deleted
        }
    }
}
