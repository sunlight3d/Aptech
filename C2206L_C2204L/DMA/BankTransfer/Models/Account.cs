using System;
using System.Collections.Generic;

namespace BankTransfer.Models;

public partial class Account
{
    public int AccountId { get; set; }

    public string? AccountType { get; set; }

    public DateTime? CreateDate { get; set; }

    public double? TotalAmount { get; set; }

    public int? UserId { get; set; }

    public virtual User? User { get; set; }
}
