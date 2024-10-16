using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("derivatives")]
    public class Derivative
    {
        [Key]
        [Column("derivative_id")]
        public int DerivativeId { get; set; }

        [Required(ErrorMessage = "Name is required")]
        [Column("name")]
        public string Name { get; set; } = "";

        [Required(ErrorMessage = "Underlying asset is required")]
        [ForeignKey(nameof(UnderlyingAsset))]

        [Column("underlying_asset_id")]
        public int UnderlyingAssetId { get; set; }
        public virtual Stock? UnderlyingAsset { get; set; }

        [Column("contract_size")]
        public int ContractSize { get; set; }

        [Required(ErrorMessage = "Expiration date is required")]
        [Column("expiration_date")]
        public DateTime ExpirationDate { get; set; }

        [Column("strike_price")]
        public decimal StrikePrice { get; set; }
        [Column("last_price")]
        [Required(ErrorMessage = "Last price is required.")]
        public decimal LastPrice { get; set; }

        [Column("change")]
        [Required(ErrorMessage = "Change is required.")]
        public decimal Change { get; set; }

        [Column("percent_change")]
        [Required(ErrorMessage = "Percent change is required.")]
        public decimal PercentChange { get; set; }

        [Column("open_price")]
        [Required(ErrorMessage = "Open price is required.")]
        public decimal OpenPrice { get; set; }

        [Column("high_price")]
        [Required(ErrorMessage = "High price is required.")]
        public decimal HighPrice { get; set; }

        [Column("low_price")]
        [Required(ErrorMessage = "Low price is required.")]
        public decimal LowPrice { get; set; }

        [Column("volume")]
        [Required(ErrorMessage = "Volume is required.")]
        public int Volume { get; set; }
    }
}

