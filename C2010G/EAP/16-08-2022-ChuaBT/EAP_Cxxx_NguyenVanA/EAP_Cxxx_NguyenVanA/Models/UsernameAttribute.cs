using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EAP_Cxxx_NguyenVanA.Models
{
    public class UsernameAttribute : ValidationAttribute
    {
        public string GetErrorMessage() =>
            $"Username must be: no _, no ., no _ in the middle";

        private bool stringNotContains(String inputString, 
            List<String> unlistedCharacters) {
            foreach(var eachString in unlistedCharacters) {
                if (inputString.Contains(eachString)) {
                    return false;
                }
            }
            return true;
        }
        protected override ValidationResult IsValid(
            object value, ValidationContext validationContext)
        {
            String username = (String)value;
            bool condition1 = username[0].Equals("_") || 
                                username[username.Length - 1].Equals("_");
            bool condition2 = username[0].Equals(".") ||
                                username[username.Length - 1].Equals(".");
            String subString = username.Substring(1, username.Length - 1);
            List<String> unlistedCharacters = new List<string> {
                "__", "._", "_.", ".."
            };
            bool condition3 = stringNotContains(subString, unlistedCharacters);
            //return new ValidationResult(GetErrorMessage());
            
            return (condition1 && condition2 && condition3) ? 
                ValidationResult.Success:
                new ValidationResult(GetErrorMessage());
        }
    }
}