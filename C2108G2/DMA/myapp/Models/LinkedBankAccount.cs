using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("linked_bank_accounts")]
    public class LinkedBankAccount
    {
        [Key]
        [Column("account_id")]
        public int AccountId { get; set; }

        [ForeignKey("User")]
        [Column("user_id")]
        public int UserId { get; set; }
        public User? User { get; set; } // Navigation property

        [Required(ErrorMessage = "Bank name is required.")]
        [Column("bank_name")]
        public string? BankName { get; set; }

        [Required(ErrorMessage = "Account number is required.")]
        [Column("account_number")]
        public string? AccountNumber { get; set; }

        [Column("routing_number")]
        public string? RoutingNumber { get; set; }

        [Column("account_type")]
        public string AccountType { get; set; } = "";

        public ICollection<Transaction>? Transactions { get; set; }
        

    }

}

