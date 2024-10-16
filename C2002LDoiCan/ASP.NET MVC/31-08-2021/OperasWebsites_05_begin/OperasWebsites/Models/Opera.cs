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
        [CheckValidTitle]
        [Required]
        [Display("tieu de")]
        public string Title { get; set; }
        [CheckValidYear]
        [Required]
        public int Year { get; set; }
        [CheckValidComposer]
        [Required]
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

    public class CheckValidTitle : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            string title = (string)value;
            if ((title == null) || (title.Length < 3))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        public CheckValidTitle()
        {
            ErrorMessage = "The title must contain at least 3 characters";
        }
    }

    public class CheckValidComposer : ValidationAttribute
    {
        public override bool IsValid(object value)
        {
            string composer = (string)value;
            if ((composer == null) || (composer.Length < 4))
            {
                return false;
            }
            else
            {
                return true;
            }
        }
        public CheckValidComposer()
        {
            ErrorMessage = "The composer must contain at least 4 characters";
        }
    }
}
