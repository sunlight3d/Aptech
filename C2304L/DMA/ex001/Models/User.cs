using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;
using ex001.Utilities;
namespace ex001.Models
{
    [Table("users")] // Chỉ định tên bảng trong DB là "users"
    public class User
    {
        [Key] // Marks this property as the primary key
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)] // Configures this as an auto-increment identity column
        public int Id { get; set; }
        [Required]
        [EmailAddress(ErrorMessage = "Type must be a valid email")]
        [Column("email")]
        public string Email { get; set; }

        [Column("role")]
        public string Role { get; set; }

        [Required]
        [MinLength(5, ErrorMessage = "FullName must be at least 5 characters long")]
 
        [Column("full_name")] // Chỉ định tên cột trong DB là "full_name"
        public string FullName { get; set; }
        //tên cột trong db lại là full_name

        // Automatically hash the password with a fixed salt when it's set
        [Column("password")]
        public string Password { get; set; }
        // Method to verify if a raw password matches the stored hashed password
      

    }
}
