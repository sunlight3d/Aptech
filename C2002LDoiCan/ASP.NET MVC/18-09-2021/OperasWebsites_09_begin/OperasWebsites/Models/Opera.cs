using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace OperasWebsites.Models
{
    public class Opera
    {
        [Required]
        public int OperaID { get; set; }
        [StringLength(200)]
        public string Title { get; set; }
        [CheckValidYear]
        [Required]
        public int Year { get; set; }
        public string Composer { get; set; }
    }


    public class CheckValidYear : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            int year = (int)value;
            if (year < 1598)
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        public CheckValidYear()
        {
            ErrorMessage = "The earliest opera is Daphne, 1598, by Corsi, Peri, and Rinuccini";
        }
    }
}