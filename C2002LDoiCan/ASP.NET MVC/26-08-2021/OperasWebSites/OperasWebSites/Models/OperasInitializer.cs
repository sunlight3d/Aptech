using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace OperasWebSites.Models
{
    public class OperasInitializer : DropCreateDatabaseAlways<OperasDB>
    {
        protected override void Seed(OperasDB context)
        {
            base.Seed(context);
            var operas = new List<Opera>
              {
                   new Opera {
                       Title = "Cosi Fan Tutte",
                       Year = 1790,
                       Composer = "Mozart"
                   },
                   new Opera {
                       Title = "Haha opera",
                       Year = 1999,
                       Composer = "Abc"
                   }
              };
            //operas in memory
            operas.ForEach(s => context.Operas.Add(s));            
            context.SaveChanges();
            //operas in Database
        }
    }
}