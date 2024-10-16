using Microsoft.EntityFrameworkCore.Migrations;
using Microsoft.EntityFrameworkCore.Update.Internal;
using System.ComponentModel.DataAnnotations;

namespace WebApiApp.Models
{
    public class Product
    {
        [Key]
        public int Id { get; set; }
        public string Name { get; set; }
        public string Description { get; set; }

        [StringLength(200, MinimumLength = 3)]
        public string Producer { get; set; }
        public decimal Price { get; set; }
        
    }
}
