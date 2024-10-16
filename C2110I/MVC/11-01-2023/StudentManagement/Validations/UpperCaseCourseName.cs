using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Validations
{
    public class UpperCaseCourseName : ValidationAttribute
    {
        public UpperCaseCourseName() { }
        
        

        public string GetErrorMessage() =>
            $"Course name must be UpperCase";

        protected override ValidationResult? IsValid(
            object? value, ValidationContext validationContext)
        {
            string inputValue = (string)value;
            foreach (var eachChar in inputValue) {
                if (!Char.IsUpper(eachChar)) {
                    return new ValidationResult(GetErrorMessage());
                }
            }
           

            return ValidationResult.Success;
        }
    }
}
