using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MusicStore.Models
{
    public class DataContext: DbContext
    {
        public virtual DbSet<Genre> Genres { get;  set; }
        public virtual DbSet<Album> Albums { get; set; }

    }
}