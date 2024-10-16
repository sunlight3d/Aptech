using System.ComponentModel.DataAnnotations;
namespace _03_07_2023.Validations
{    
    public class MatchPasswordAttribute : ValidationAttribute
    {
        private readonly string _passwordPropertyName;

        public MatchPasswordAttribute(string passwordPropertyName)
        {
            _passwordPropertyName = passwordPropertyName;
        }

        protected override ValidationResult IsValid(object value, ValidationContext validationContext)
        {
            var passwordProperty = validationContext.ObjectType.GetProperty(_passwordPropertyName);
            var passwordValue = passwordProperty?.GetValue(validationContext.ObjectInstance, null);

            if (value != null && passwordValue != null && !value.Equals(passwordValue))
            {
                return new ValidationResult(ErrorMessage);
            }

            return ValidationResult.Success;
        }
    }

}
