using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
namespace de07.Models
{    

    public class ServiceCategory
    {
        [Key]
        public int ServiceCategoryId { get; set; }

        [Required(ErrorMessage = "The service category name is required.")]
        [StringLength(100, ErrorMessage = "The service category name must not exceed 100 characters.")]
        public string ServiceCategoryName { get; set; }

        [StringLength(500, ErrorMessage = "The service category description must not exceed 500 characters.")]
        public string ServiceCategoryDescription { get; set; }

        // List of services that belong to this category
        public ICollection<Service> Services { get; set; }
    }

}
