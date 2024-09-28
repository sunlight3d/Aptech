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

        [Required]
        [MinLength(5, ErrorMessage = "FullName must be at least 5 characters long")]
 
        [Column("full_name")] // Chỉ định tên cột trong DB là "full_name"
        public string FullName { get; set; }
        //tên cột trong db lại là full_name

        //Mật khẩu chưa mã hoá yêu cầu ít nhất 6 ký tự, tuy nhiên đây là mật khẩu đã mã hoá
        private string _passwordHash;

        // Automatically hash the password with a fixed salt when it's set
        [Column("password")]
        public string Password
        {
            get => _passwordHash;
            set
            {
                // Hash the password with the fixed salt
                _passwordHash = PasswordHasher.HashPassword(value);
            }
        }
        // Method to verify if a raw password matches the stored hashed password
        public bool IsMatch(string rawPassword)
        {
            // Hash the raw password with the fixed salt
            var hash = PasswordHasher.HashPassword(rawPassword);
            // Check if the hash matches the stored hash
            return hash == _passwordHash;
        }

    }
}
