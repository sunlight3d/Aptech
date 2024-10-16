using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EAP_C2002L_NguyenVanA.Models
{
    public class DataContext: DbContext
    {
        
        //contains all tables
        public virtual DbSet<Product> Products { get; set; }
        public virtual DbSet<Category> Categories { get; set; }        

        public DataContext()
            :base(ConfigurationManager.ConnectionStrings["databaseConnection"].ConnectionString) {            
            if (!Database.Exists())
            {
                Database.Initialize(true);                
            }
            DataInitializer dataInitializer = new DataInitializer();
            Database.SetInitializer<DataContext>(dataInitializer);
            //dataInitializer.InitDB(this);
        }
    }
}