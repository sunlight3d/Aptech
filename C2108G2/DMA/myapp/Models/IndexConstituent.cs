using System;
using Microsoft.EntityFrameworkCore.Metadata.Internal;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("index_constituents")]
    public class IndexConstituent
    {
        [Key]
        [Column("index_id", TypeName = "int")]
        public int IndexId { get; set; }

        [ForeignKey("IndexId")]
        public MarketIndex? MarketIndex { get; set; }

        [Key]
        [Column("stock_id", TypeName = "int")]
        public int StockId { get; set; }

        [ForeignKey("StockId")]
        public Stock? Stock { get; set; }
    }
}

