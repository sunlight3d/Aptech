using System;
using System.ComponentModel.DataAnnotations;
namespace bai05.Models
{    
    public class Order
    {
        public int Id { get; set; }

        [Required]
        [DataType(DataType.DateTime)]
        public DateTime OrderDate { get; set; }

        [Required]
        [StringLength(15, MinimumLength = 6)]
        public string CustomerPhone { get; set; }

        [Required]
        public int ProductId { get; set; }

        [Required]
        [Range(1, int.MaxValue, ErrorMessage = "Quantity must be at least 1.")]
        public int Quantity { get; set; }

        // Navigation property for the foreign key relationship
        public Product Product { get; set; }
    }

}
