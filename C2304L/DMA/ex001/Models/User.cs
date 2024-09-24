using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

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
        public string Email { get; set; }

        [Required]
        [MinLength(5, ErrorMessage = "FullName must be at least 5 characters long")]
 
        [Column("full_name")] // Chỉ định tên cột trong DB là "full_name"
        public string FullName { get; set; }
        //tên cột trong db lại là full_name

        //Hai trường Password và RetypePassword có thể null, nếu khác null thì mới check độ dài và check nội dung
        [MinLength(6, ErrorMessage = "Password must be at least 6 characters long")]
        public string Password { get; set; }

        /*
        private int _age;

        // Public property with getter and setter
        public int Age
        {
            get { return _age; }
            set
            {
                if (value < 0 || value > 150)
                {
                    throw new ArgumentOutOfRangeException("Age must be between 0 and 150.");
                }
                _age = value;
            }
        }
        */
    }
}
