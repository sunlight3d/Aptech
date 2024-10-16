using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C1908i_DuongDucAnh.Models
{
    public class DataContext: DbContext
    {
        public virtual DbSet<Subject> Subjects { get; set; }
        public virtual DbSet<Student> Students { get; set; }
        public virtual DbSet<Exam> Exams { get; set; }
        public DataContext() : base("name=DefaultConnection")
        {
            //Database.SetInitializer<DataContext>(new CreateDatabaseIfNotExists<DataContext>());
            
            
            
            
            Database.SetInitializer<DataContext>(new DataInitializer());
        }        
    }
}