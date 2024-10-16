namespace ProjectAppDotNetCore.Validations
{
    using System;
    using System.ComponentModel.DataAnnotations;

    public class EmployeeAgeValidationAttribute : ValidationAttribute
    {
        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            if (value is DateTime dob)
            {
                var currentDate = DateTime.Today;
                var age = currentDate.Year - dob.Year;

                // Kiểm tra năm sinh và ngày hiện tại, nếu chưa đến sinh nhật thì giảm 1 tuổi
                if (dob.Date > currentDate.AddYears(-age))
                {
                    age--;
                }

                const int minAgeRequired = 16;

                if (age < minAgeRequired)
                {
                    return new ValidationResult("Employee must be over 16 years old.");
                }

                return ValidationResult.Success;
            }

            return new ValidationResult("Employee DOB must be a date type.");
        }
    }

}
