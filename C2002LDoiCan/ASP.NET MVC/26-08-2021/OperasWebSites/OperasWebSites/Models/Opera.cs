using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace OperasWebSites.Models
{
    public class Opera
    {
        
        public int OperaID { get; set; }

        [Required]
        [StringLength(200)]
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
        public CheckValidYear()
        {
            ErrorMessage = "Year must be >= 1958";
        }
    }
}