using System;
using myapp.Models;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("orders")]
    public class Order
    {
        [Column("order_id")]
        public int OrderId { get; set; }

        [Column("user_id")]
        public int UserId { get; set; }

        [ForeignKey("UserId")]
        public virtual User? User { get; set; }

        [Column("stock_id")]
        public int StockId { get; set; }

        [ForeignKey("StockId")]
        public virtual Stock? Stock { get; set; }

        [Column("order_type")]
        public string OrderType { get; set; } = "";

        [Column("direction")]
        public string Direction { get; set; } = "";

        [Column("quantity")]
        public int Quantity { get; set; }

        [Column("price")]
        public decimal Price { get; set; }

        [Column("status")]
        public string Status { get; set; } = "";

        [Column("order_date")]
        public DateTime OrderDate { get; set; }
    }
}


