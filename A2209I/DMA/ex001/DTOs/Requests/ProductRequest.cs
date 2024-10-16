using System.ComponentModel.DataAnnotations;

namespace ex001.DTOs.Requests
{
    public class ProductRequest
    {
        public string Name { get; set; }
        public string Description { get; set; }

        [Required]
        [DataType(DataType.Currency)]
        public decimal Price { get; set; }

        [Required]
        public int Stock { get; set; }
    }
}
