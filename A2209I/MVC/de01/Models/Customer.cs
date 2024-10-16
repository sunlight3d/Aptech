using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Security.Claims;

namespace de01.Models
{
    [Table("Customer")]
    public class Customer
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("CustomerId")]
        public int Id { get; set; }

        [Required]
        [StringLength(128, ErrorMessage = "Full name cannot be longer than 128 characters.")]
        public string Fullname { get; set; }

        [Required]
        [DataType(DataType.Date)]
        public DateTime Birthday { get; set; } = new DateTime(1975, 4, 30);

        [StringLength(255, ErrorMessage = "Address cannot be longer than 255 characters.")]
        public string Address { get; set; } = "One Infinite Loop Cupertino, California 95014";

        [Required]
        [EmailAddress]
        [StringLength(96, ErrorMessage = "Email cannot be longer than 96 characters.")]
        public string Email { get; set; }

        [Required]
        [StringLength(20, ErrorMessage = "Username cannot be longer than 20 characters.")]
        public string Username { get; set; }

        [Required]
        [DataType(DataType.Password)]
        [StringLength(100, ErrorMessage = "Password must be between 6 and 100 characters long.", MinimumLength = 6)]
        public string Password { get; set; }

        [DataType(DataType.Password)]
        [Compare("Password", ErrorMessage = "The password and confirmation password do not match.")]
        public string ConfirmPassword { get; set; }

        [Required]
        [ForeignKey("Klass")]
        [Column("ClassId")]
        public int ClassId { get; set; }

        public Klass Klass { get; set; }
    }

}
