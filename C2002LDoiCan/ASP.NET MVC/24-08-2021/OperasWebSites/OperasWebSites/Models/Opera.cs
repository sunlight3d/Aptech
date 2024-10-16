using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace OperasWebSites.Models
{
    public class Opera
    {
        [Required]
        [StringLength(200)]
        public int OperaID { get; set; }
        public string Title { get; set; }
        [Required]
        [CheckValidYear]
        public int Year { get; set; }
        public string Composer { get; set; }
    }
    //custom validation
    public class CheckValidYear : ValidationAttribute
    {
        public override bool IsValid(object value) => (int)value >= 1598;
    }
}