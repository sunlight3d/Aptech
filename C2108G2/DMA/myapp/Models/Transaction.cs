using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace myapp.Models
{    
    [Table("transactions")]
    public class Transaction
    {
        [Key]
        [Column("transaction_id")]
        public int TransactionId { get; set; }

        [Required(ErrorMessage = "User ID is required")]
        [ForeignKey(nameof(User))]
        [Column("user_id")]
        public int UserId { get; set; }
        public User? User { get; set; }

        [Required(ErrorMessage = "Linked account ID is required")]
        [ForeignKey(nameof(LinkedBankAccount))]
        [Column("linked_account_id")]
        public int LinkedAccountId { get; set; }
        public LinkedBankAccount? LinkedBankAccount { get; set; }

        [Required(ErrorMessage = "Transaction type is required")]
        [Column("transaction_type")]
        public string TransactionType { get; set; } = "";

        [Required(ErrorMessage = "Amount is required")]
        [Column("amount")]
        public decimal Amount { get; set; }

        [Required(ErrorMessage = "Transaction date is required")]
        [Column("transaction_date")]
        public DateTime TransactionDate { get; set; }
    }

}

