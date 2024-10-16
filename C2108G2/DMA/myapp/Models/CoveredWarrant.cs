using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("covered_warrants")]
    public class CoveredWarrant
    {
        [Key]
        
        [Column("warrant_id")]
        public int WarrantId { get; set; }

        [Required]
        [Column("name")]
        public string Name { get; set; } = "";

        [ForeignKey(nameof(UnderlyingAsset))]
        [Column("underlying_asset_id")]        
        public int UnderlyingAssetId { get; set; }
        public virtual Stock? UnderlyingAsset { get; set; }

        [Required]
        [Column("issue_date")]
        public DateTime IssueDate { get; set; }

        [Required]
        [Column("expiration_date")]
        public DateTime ExpirationDate { get; set; }

        [Required]
        [Column("strike_price")]
        public decimal StrikePrice { get; set; }

        [Required]
        [Column("warrant_type")]
        public string WarrantType { get; set; } = "";
    }

}

