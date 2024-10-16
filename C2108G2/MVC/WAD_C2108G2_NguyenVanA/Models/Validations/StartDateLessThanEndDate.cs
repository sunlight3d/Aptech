using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace WAD_C2108G2_NguyenVanA.Models.Validations
{
    using System.ComponentModel.DataAnnotations;

    public class StartDateLessThanEndDate : ValidationAttribute
    {
        protected override ValidationResult IsValid(
            object value, ValidationContext validationContext)
        {
            var project = (Project)validationContext.ObjectInstance;

            if (project.ProjectStartDate >= project.ProjectEndDate)
            {
                return new ValidationResult("End date must be after start date.");
            }

            return ValidationResult.Success;
        }
    }
}