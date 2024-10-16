using System;
using System.Collections.Generic;
using Microsoft.EntityFrameworkCore;

namespace DipplomaApp.Models;

public partial class DlmmsContext : DbContext
{
    private readonly IConfiguration configuration;    
    public DlmmsContext()
    {
        //this.configuration = configuration;
    }

    public DlmmsContext(
        DbContextOptions<DlmmsContext> options        
        
    )
        : base(options)
    {
        Console.WriteLine("aa");
    }

    public virtual DbSet<Diploma> Diplomas { get; set; }

    public virtual DbSet<DiplomaType> DiplomaTypes { get; set; }

    public virtual DbSet<Rank> Ranks { get; set; }

    public virtual DbSet<Sex> Sexes { get; set; }

    public virtual DbSet<TrainingProgram> TrainingPrograms { get; set; }

    public virtual DbSet<TrainingType> TrainingTypes { get; set; }

    public virtual DbSet<User> Users { get; set; }

    /*
    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    //#warning To protect potentially sensitive information in your connection string, you should move it out of source code. You can avoid scaffolding the connection string by using the Name= syntax to read it from configuration - see https://go.microsoft.com/fwlink/?linkid=2131148. For more guidance on storing connection strings, see http://go.microsoft.com/fwlink/?LinkId=723263.
    {
        optionsBuilder.UseSqlServer(configuration.GetConnectionString("SQLServerConnection"));
    }
    */
    

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Diploma>(entity =>
        {
            entity.ToTable("DIPLOMA");

            entity.Property(e => e.DiplomaId).HasColumnName("DiplomaID");
            entity.Property(e => e.BirthPlace).HasMaxLength(100);
            entity.Property(e => e.Colour).HasMaxLength(30);
            entity.Property(e => e.DecideCode).HasMaxLength(30);
            entity.Property(e => e.DiplomaTypeId).HasColumnName("DiplomaTypeID");
            entity.Property(e => e.Dob)
                .HasColumnType("datetime")
                .HasColumnName("DOB");
            entity.Property(e => e.FullName).HasMaxLength(60);
            entity.Property(e => e.Language).HasMaxLength(30);
            entity.Property(e => e.NumberSign).HasMaxLength(30);
            entity.Property(e => e.RankId).HasColumnName("RankID");
            entity.Property(e => e.RegisterNumber).HasMaxLength(30);
            entity.Property(e => e.SexId).HasColumnName("SexID");
            entity.Property(e => e.Size).HasMaxLength(30);
            entity.Property(e => e.TrainingProgramId).HasColumnName("TrainingProgramID");
            entity.Property(e => e.TrainingTypeId).HasColumnName("TrainingTypeID");
            entity.Property(e => e.VolumedBook).HasMaxLength(20);

            entity.HasOne(d => d.DiplomaType).WithMany(p => p.Diplomas)
                .HasForeignKey(d => d.DiplomaTypeId)
                .HasConstraintName("FK_DIPLOMA_DIPLOMA_TYPE");

            entity.HasOne(d => d.Rank).WithMany(p => p.Diplomas)
                .HasForeignKey(d => d.RankId)
                .HasConstraintName("FK_DIPLOMA_RANK");

            entity.HasOne(d => d.Sex).WithMany(p => p.Diplomas)
                .HasForeignKey(d => d.SexId)
                .HasConstraintName("FK_DIPLOMA_SEX");

            entity.HasOne(d => d.TrainingProgram).WithMany(p => p.Diplomas)
                .HasForeignKey(d => d.TrainingProgramId)
                .HasConstraintName("FK_DIPLOMA_TRAINING_PROGRAM");

            entity.HasOne(d => d.TrainingType).WithMany(p => p.Diplomas)
                .HasForeignKey(d => d.TrainingTypeId)
                .HasConstraintName("FK_DIPLOMA_TRAINING_TYPE");
        });

        modelBuilder.Entity<DiplomaType>(entity =>
        {
            entity.ToTable("DIPLOMA_TYPE");

            entity.Property(e => e.DiplomaTypeId).HasColumnName("DiplomaTypeID");
            entity.Property(e => e.Colour).HasMaxLength(50);
            entity.Property(e => e.DilomaTypeName).HasMaxLength(255);
            entity.Property(e => e.Language).HasMaxLength(50);
            entity.Property(e => e.OrganizationIssue).HasMaxLength(255);
            entity.Property(e => e.PersonIssue).HasMaxLength(255);
            entity.Property(e => e.Position).HasMaxLength(255);
            entity.Property(e => e.Size).HasMaxLength(50);
        });

        modelBuilder.Entity<Rank>(entity =>
        {
            entity.ToTable("RANK");

            entity.Property(e => e.RankId).HasColumnName("RankID");
            entity.Property(e => e.RankName).HasMaxLength(50);
        });

        modelBuilder.Entity<Sex>(entity =>
        {
            entity.ToTable("SEX");

            entity.Property(e => e.SexId)
                .ValueGeneratedNever()
                .HasColumnName("SexID");
            entity.Property(e => e.SexName).HasMaxLength(255);
        });

        modelBuilder.Entity<TrainingProgram>(entity =>
        {
            entity.ToTable("TRAINING_PROGRAM");

            entity.Property(e => e.TrainingProgramId).HasColumnName("TrainingProgramID");
            entity.Property(e => e.TrainingProgram1)
                .HasMaxLength(255)
                .HasColumnName("TrainingProgram");
            entity.Property(e => e.TrainingTypeId).HasColumnName("TrainingTypeID");

            entity.HasOne(d => d.TrainingType).WithMany(p => p.TrainingPrograms)
                .HasForeignKey(d => d.TrainingTypeId)
                .HasConstraintName("FK_TRAINING_PROGRAM_TRAINING_TYPE");
        });

        modelBuilder.Entity<TrainingType>(entity =>
        {
            entity.ToTable("TRAINING_TYPE");

            entity.Property(e => e.TrainingTypeId).HasColumnName("TrainingTypeID");
            entity.Property(e => e.TrainingTypeCode).HasMaxLength(50);
            entity.Property(e => e.TrainingTypeName).HasMaxLength(255);
        });

        modelBuilder.Entity<User>(entity =>
        {
            entity.HasKey(e => e.UsersId);

            entity.ToTable("USERS");

            entity.Property(e => e.UsersId)
                .ValueGeneratedNever()
                .HasColumnName("UsersID");
            entity.Property(e => e.Discription).HasMaxLength(255);
            entity.Property(e => e.Password).HasMaxLength(255);
            entity.Property(e => e.UserName).HasMaxLength(50);
        });

        OnModelCreatingPartial(modelBuilder);
    }

    partial void OnModelCreatingPartial(ModelBuilder modelBuilder);
}
