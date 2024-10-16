using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EAP_C2009i_NguyenVanA.Models
{
    public class Product
    {
        [Key]
        [Required]
        public int ProductId { get; set; }
        [Required]
        [StringLength(32, MinimumLength =3)]
        public string Name { get; set; }
        [DataType(DataType.DateTime)]
        public DateTime ReleaseDate { get; set; }
        [Required]
        [Range(1, 100, ErrorMessage ="Range must be 1 to 100")]
        public int Quantity { get; set; }
        [Required]
        [Range(0, double.MaxValue, ErrorMessage = "Please enter valid doubleNumber")]
        public double Price { get; set; }
        [Required]
        public int CategoryId { get; set; }
        public virtual Category Category { get; set; }
             
    }
}