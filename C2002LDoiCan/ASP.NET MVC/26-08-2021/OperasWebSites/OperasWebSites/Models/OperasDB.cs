using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;//Stream in Java
using System.Web;

namespace OperasWebSites.Models
{
    public class OperasDB: DbContext
    {
        //n tables => n DBSets
        public DbSet<Opera> Operas { get; set; }
        //how to create initial data ?
        //Code First 
    }
}