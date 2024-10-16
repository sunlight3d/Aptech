using System;
using System.ComponentModel.DataAnnotations;
namespace ProjectAppDotNetCore.Validations
{
    
    public class ProjectDateValidationAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var projectStartDate = (DateTime)validationContext.ObjectType.GetProperty("ProjectStartDate").GetValue(validationContext.ObjectInstance, null);
            var projectEndDate = (DateTime?)value;

            if (projectEndDate != null && projectStartDate >= projectEndDate)
            {
                return new ValidationResult("ProjectStartDate must be earlier than ProjectEndDate when ProjectEndDate is not null.");
            }

            return ValidationResult.Success;
        }
    }

}
