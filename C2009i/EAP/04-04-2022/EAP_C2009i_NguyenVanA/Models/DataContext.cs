using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EAP_C2009i_NguyenVanA.Models
{
    public class DataContext:DbContext
    {
        public virtual DbSet<Category> Categories { get; set; }
        public virtual DbSet<Product> Products { get; set; }
        
        public DataContext() {
            //Database.SetInitializer(new DataInitializer(this));
        }
    }
    
}