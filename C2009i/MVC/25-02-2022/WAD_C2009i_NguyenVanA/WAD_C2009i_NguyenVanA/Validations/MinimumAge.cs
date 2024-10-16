using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2009i_NguyenVanA.Validations
{
    public class MinimumAge: ValidationAttribute
    {
        private int minAge;
        public MinimumAge(int minAge) { 
            this.minAge = minAge;
        }
        public override bool IsValid(object value) {
            DateTime inputDateTime = (DateTime)value;
            return DateTime.Today.Year - inputDateTime.Year >= minAge;            
        }
    }
}