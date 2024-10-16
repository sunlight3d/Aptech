using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EAP_C2002L_NguyenVanA.Models
{
    public class Category
    {
        public int CategoryId { get; set; }
        public string CategoryName { get; set; }
        public virtual ICollection<Product> Products { get; set; }
        public Category() {
            Products = new HashSet<Product>();
        }
    }
}