namespace ex001.Models
{
    using System;
    using System.ComponentModel.DataAnnotations;
    using System.ComponentModel.DataAnnotations.Schema;

    [Table("products")]
    //SQL Server: Products, Product, tblProduct, bang_SP(NO !)
    //mysql: products, tbl_products
    public class Product
    {
        [Key] // Marks this property as the primary key
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)] // Configures as an auto-increment identity column
        [Required] // Ensures Id is required
        public int Id { get; set; }

        [Required(ErrorMessage = "Product Name is required.")]
        [StringLength(100, MinimumLength = 3, ErrorMessage = "Product Name must be between 3 and 100 characters.")]
        public string Name { get; set; }

        [StringLength(500, ErrorMessage = "Description cannot exceed 500 characters.")]
        public string Description { get; set; }

        [Required(ErrorMessage = "Price is required.")]
        [Range(0.01, 10000, ErrorMessage = "Price must be between 0.01 and 10,000.")]
        public decimal Price { get; set; }
    }

}
