using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace myapp.Models
{
    [Table("market_indices")]
    public class MarketIndex
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("index_id")]
        public int IndexId { get; set; }

        [Required(ErrorMessage = "Name is required")]
        [Column("name")]
        [MaxLength(255, ErrorMessage = "Name cannot exceed 255 characters")]
        public string Name { get; set; } = "";

        [Required(ErrorMessage = "Symbol is required")]
        [Column("symbol")]
        [MaxLength(50, ErrorMessage = "Symbol cannot exceed 50 characters")]
        public string Symbol { get; set; } = "";

        public ICollection<IndexConstituent>? IndexConstituents { get; set; }
    }
}

