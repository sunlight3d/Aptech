using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EAP_C2009G_NguyenVanA.Models
{
    public class DataContext:DbContext
    {
        public virtual DbSet<Genre> Genres { get; set; }
        public virtual DbSet<Movie> Movies { get; set; }
        public DataContext() { 

        }
    }
}