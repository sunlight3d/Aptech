using System;
using System.Collections.Generic;

namespace BankTransfer.Models;

public partial class Transaction
{
    public int TransactionId { get; set; }

    public int? RequestId { get; set; }

    public int? ReceiverId { get; set; }

    public DateTime? TransferTime { get; set; }

    public string? Reason { get; set; }

    public double? Amount { get; set; }

    public virtual User? Receiver { get; set; }

    public virtual User? Request { get; set; }
}
