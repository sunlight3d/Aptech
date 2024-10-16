using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace WAD_C2110i_NguyenVanA.Models
{
    public class EmployeeDOBValidation: ValidationAttribute
{
    protected override ValidationResult IsValid(object value, ValidationContext validationContext)
    {
        var employee = (Employee)validationContext.ObjectInstance;
        var age = DateTime.Today.Year - employee.EmployeeDOB.Year;

        if (age < 16)
        {
            return new ValidationResult("Employee must be over 16 years old.");
        }

        return ValidationResult.Success;
    }
}
