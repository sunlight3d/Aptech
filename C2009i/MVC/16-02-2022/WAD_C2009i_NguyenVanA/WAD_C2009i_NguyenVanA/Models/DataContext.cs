using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace WAD_C2009i_NguyenVanA.Models
{
    public class DataContext:DbContext
    {
        public virtual DbSet<Subject> Subjects { get; set; }
        public virtual DbSet<Exam> Exams { get; set; }
        public virtual DbSet<Student> Students { get; set; }        
        public DataContext(): base("DataContext")
        {
            Database.SetInitializer<DataContext>(new DataInitializer());
            DataContext context = this;
            context.SaveChanges();
        }
    }
}