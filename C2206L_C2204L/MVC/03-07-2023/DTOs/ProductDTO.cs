using System.ComponentModel.DataAnnotations;

namespace _03_07_2023.DTOs
{    
    public class ProductDTO
    {
        [Required]
        public string Name { get; set; }

        [Range(0, 100000000, ErrorMessage = "Price must be between 0 and 100,000,000")]
        public float Price { get; set; }

        [Range(0, int.MaxValue, ErrorMessage = "Count must be greater than or equal 0")]
        public int Count { get; set; }

        public string? Description { get; set; }
    }
}
