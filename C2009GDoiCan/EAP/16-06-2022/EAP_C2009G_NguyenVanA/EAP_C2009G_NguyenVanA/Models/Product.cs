using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EAP_C2009G_NguyenVanA.Models
{
    public class Product
    {
        public int ProductId { get; set; }
        public string Name { get; set; }
        public System.DateTime ReleaseDate { get; set; }
        public int Quantity { get; set; }
        public double Price { get; set; }
        public int CategoryId { get; set; }
        [Newtonsoft.Json.JsonIgnore]
        public Category Category { get; set; }
    }
}