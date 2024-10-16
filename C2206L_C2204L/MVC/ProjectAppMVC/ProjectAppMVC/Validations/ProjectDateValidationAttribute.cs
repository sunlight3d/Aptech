using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace ProjectAppMVC.Validations
{
    public class ProjectDateValidationAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var projectStartDate = (DateTime)validationContext.ObjectType.GetProperty("ProjectStartDate").GetValue(validationContext.ObjectInstance, null);
            var projectEndDate = (DateTime)validationContext.ObjectType.GetProperty("ProjectEndDate").GetValue(validationContext.ObjectInstance, null);
            if (projectEndDate == null) {
                projectEndDate = DateTime.Now;
            }
            
            if (projectEndDate != null && projectStartDate >= projectEndDate)
            {
                return new ValidationResult("ProjectStartDate must be earlier than ProjectEndDate when ProjectEndDate is not null.");
            }

            return ValidationResult.Success;
        }
    }
}