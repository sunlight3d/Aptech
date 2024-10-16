using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace myapp.Models
{
    public class DataContext : DbContext
    {
        public DbSet<Chat> chats;
        public DbSet<User> users;
        public DataContext() {
            Database.SetInitializer<DataContext>(
                new CreateDatabaseIfNotExists<DataContext>()
            );
        }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            base.OnModelCreating(modelBuilder);

        }
        
    }
}