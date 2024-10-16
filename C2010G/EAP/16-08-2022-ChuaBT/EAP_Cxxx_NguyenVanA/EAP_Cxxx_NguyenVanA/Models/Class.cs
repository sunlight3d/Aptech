using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EAP_Cxxx_NguyenVanA.Models
{
    public class Class
    {        
        public int ClassId { get; set; }
        [Required]
        public string ClassName { get; set; }
        public virtual ICollection<Customer> Customers { get; set; }
        public Class() {
            Customers = new HashSet<Customer>();
        }

    }
}