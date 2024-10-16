using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EAP_Cxxx_NguyenVanA.Models
{
    public class DataContext:DbContext
    {

        public virtual DbSet<Class> Classes { get; set;}
        public virtual DbSet<Customer> Customers { get; set; }
        public DataContext() {
            Database.SetInitializer<DataContext>(new DataInitializer());
        }        
    }
}