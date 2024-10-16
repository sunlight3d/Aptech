using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("users")]
    public class User
    {
        [Key]
        [Column("user_id")]
        public int UserId { get; set; }

        [Required]
        [MaxLength(50)]
        [Column("username")]
        public string Username { get; set; } = "";

        [Required]
        [MaxLength(255)]
        [Column("hashed_password")]
        public string HashedPassword { get; set; } = "";

        [Required]
        [MaxLength(255)]
        [Column("email")]
        public string Email { get; set; } = ""; 

        [Required]
        [MaxLength(20)]
        [Column("phone")]
        public string Phone { get; set; } = "";

        [MaxLength(255)]
        [Column("full_name")]
        public string FullName { get; set; } = "";

        [Column("date_of_birth")]
        public DateTime? DateOfBirth { get; set; }

        [MaxLength(255)]
        public string Country { get; set; } = "";

        public ICollection<LinkedBankAccount>? LinkedBankAccounts { get; set; }
        public ICollection<Notification>? Notifications { get; set; }
        public ICollection<Order>? Orders { get; set; }
        public ICollection<Portfolio>? Portfolios { get; set; }
        public ICollection<Transaction>? Transactions { get; set; }
        public ICollection<UserDevice>? UserDevices { get; set; }
        public ICollection<Watchlist>? Watchlists { get; set; }
    }
}
