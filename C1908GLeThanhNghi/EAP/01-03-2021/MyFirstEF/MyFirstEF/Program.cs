using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace MyFirstEF
{
    class Program
    {
        static void Main(string[] args)
        {
            var dbInitializer = new CreateDatabaseIfNotExists<MyDbContext>();
            dbInitializer.InitializeDatabase(new MyDbContext());
        }
    }
}
