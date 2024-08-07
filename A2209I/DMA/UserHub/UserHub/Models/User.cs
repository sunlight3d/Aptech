using Microsoft.EntityFrameworkCore;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Text.Json.Serialization;

namespace UserHub.Models
{
    [Table("Users")]
    public class User
    {
        [Key]
        public int Id { get; set; }
        [Required]
        [StringLength(200, ErrorMessage = "Email must be at least 200 characters")]
        public string Email { get; set; }
        [Required]

        [StringLength(255)]
        public string PasswordHash { get; set; }
        [Required]
        [StringLength(255)]
        public string FullName { get; set; }


        [DataType(DataType.PhoneNumber)]
        [RegularExpression(@"^\(?([0-9]{3})\)?([-\. ])?([0-9]{3})([-\. ])?([0-9]{4,10})$",
            ErrorMessage = "Not a valid phone number")]
        [StringLength(100)]
        public string PhoneNumber { get; set; }

        

        [StringLength(50)]
        public string Role { get; set; } = "user";

        // Navigation property for the one-to-many relationship with Post
        [JsonIgnore]
        public virtual ICollection<Post> Posts { get; set; } = new List<Post>();

        /*
        ALTER TABLE Users ALTER COLUMN Email VARCHAR (200) NOT NULL;
        ALTER TABLE Users ADD CONSTRAINT UC_User UNIQUE(Email);

        ALTER TABLE Users ALTER COLUMN PasswordHash VARCHAR (255) NOT NULL;
        ALTER TABLE Users ALTER COLUMN FullName VARCHAR (255) NOT NULL;

         */
    }

}
