using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.EntityFrameworkCore;
using project01.Models;

namespace project01.Data
{
    public class DataContext : DbContext
    {
        public DataContext (DbContextOptions<DataContext> options)
            : base(options)
        {
        }

        public DbSet<project01.Models.Ward> Wards { get; set; } = default!;
        public DbSet<project01.Models.Nurse> Nurses { get; set; } = default!;
    }
}
