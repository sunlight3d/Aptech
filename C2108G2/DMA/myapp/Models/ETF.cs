using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("etfs")]
    public class ETF
    {
        [Key]
        [Column("etf_id")]
        public int EtfId { get; set; }

        [Required(ErrorMessage = "ETF name is required")]
        [MaxLength(255)]
        [Column("name")]
        public string Name { get; set; } = "";

        [Required(ErrorMessage = "ETF symbol is required")]
        [MaxLength(50)]
        [Column("symbol")]
        public string Symbol { get; set; } = "";

        [MaxLength(255)]
        [Column("management_company")]
        public string ManagementCompany { get; set; } = "";

        [Required(ErrorMessage = "ETF inception date is required")]
        [Column("inception_date")]
        public DateTime InceptionDate { get; set; }

        public ICollection<ETFQuote>? ETFQuotes { get; set; }
    }

}

