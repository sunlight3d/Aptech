using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EAP_C2103L_NguyenVanA.Models
{
    public class Product
    {
        public int ProductId { get; set; }
        [Required]
        [StringLength(32, MinimumLength = 3)]
        public string Name { get; set; }
        [Required]
        [DataType(DataType.Date)]
        public DateTime ReleaseDate { get; set; }
        [Required]
        [Range(1, 100)]
        public int Quantity { get; set; }

        [Required]
        [RegularExpression(@"^\d+\.\d{0,2}$")]
        public double Price { get; set; }
        //navigation props
        public int CategoryId { get; set; }
        [Newtonsoft.Json.JsonIgnore]
        public virtual Category Category { get; set; }

    }
}