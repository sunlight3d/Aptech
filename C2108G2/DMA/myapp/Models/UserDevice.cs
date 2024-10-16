using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("user_devices")]
    public class UserDevice
    {
        public int Id { get; set; }

        [Required]
        [Column("user_id")]
        public int UserId { get; set; }

        [Required]
        [MaxLength(255)]
        [Column("device_id")]
        public string? DeviceId { get; set; }

        [Required]
        [MaxLength(255)]
        public string Token { get; set; } = "";

        [Required]
        [Column("token_expiration")]
        public DateTime TokenExpiration { get; set; }

        [ForeignKey("UserId")]
        public User? User { get; set; }
    }
}

