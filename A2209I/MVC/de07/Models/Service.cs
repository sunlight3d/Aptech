namespace de07.Models
{
    using System.ComponentModel.DataAnnotations;

    public class Service
    {
        [Key]
        public int ServiceId { get; set; }

        [Required(ErrorMessage = "The service name is required.")]
        [StringLength(100, ErrorMessage = "The service name must not exceed 100 characters.")]
        public string ServiceName { get; set; }

        [Required(ErrorMessage = "The price of the service is required.")]
        [Range(0, double.MaxValue, ErrorMessage = "The price must be a positive number.")]
        public decimal Price { get; set; }

        [Required(ErrorMessage = "The service quantity is required.")]
        [Range(0, int.MaxValue, ErrorMessage = "The service quantity must be a non-negative number.")]
        public int ServiceNumber { get; set; }

        // Assuming each service belongs to a service category
        public int ServiceCategoryId { get; set; }
        public ServiceCategory ServiceCategory { get; set; }
    }


}
