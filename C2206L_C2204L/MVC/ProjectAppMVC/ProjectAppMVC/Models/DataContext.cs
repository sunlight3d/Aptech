using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace ProjectAppMVC.Models
{
    public class DataContext : DbContext
    {

        public DataContext() : base("DefaultConnection")
        {
            //DataInitializer.Seed(this);//seed at "Global.asax"
            
        }

        public virtual DbSet<Project> Projects { get; set; }
        public virtual DbSet<Employee> Employees { get; set; }
        public virtual DbSet<ProjectEmployee> ProjectEmployees { get; set; }
        
        

    }
}