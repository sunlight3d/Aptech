using System;
using System.Collections.Generic;
using System.Reflection.Emit;
using Microsoft.EntityFrameworkCore;

namespace de01.Models
{
    public class DiplomaDbContext : DbContext
    {
        public DiplomaDbContext(DbContextOptions<DiplomaDbContext> options) : base(options)
        {
        }

        public DbSet<Diploma> Diplomas { get; set; }
        public DbSet<DiplomaType> DiplomaTypes { get; set; }
        public DbSet<Rank> Ranks { get; set; }
        public DbSet<Sex> Sexes { get; set; }
        public DbSet<TrainingProgram> TrainingPrograms { get; set; }
        public DbSet<TrainingType> TrainingTypes { get; set; }
        public DbSet<User> Users { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<Diploma>()
                .HasOne(d => d.DiplomaType)
                .WithMany(dt => dt.Diplomas)
                .HasForeignKey(d => d.DiplomaTypeID);

            modelBuilder.Entity<Diploma>()
                .HasOne(d => d.Rank)
                .WithMany(r => r.Diplomas)
                .HasForeignKey(d => d.RankID);

            modelBuilder.Entity<Diploma>()
                .HasOne(d => d.Sex)
                .WithMany(s => s.Diplomas)
                .HasForeignKey(d => d.SexID);

            modelBuilder.Entity<Diploma>()
                .HasOne(d => d.TrainingProgram)
                .WithMany(tp => tp.Diplomas)
                .HasForeignKey(d => d.TrainingProgramID);
            /*
            modelBuilder.Entity<Diploma>()
                .HasOne(d => d.TrainingType)
                .WithMany(tt => tt.Diplomas)
                .HasForeignKey(d => d.TrainingTypeID);
            */
            modelBuilder.Entity<User>()
                .HasKey(u => u.UsersID);
        }
    }

}

