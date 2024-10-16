using System.ComponentModel.DataAnnotations;

namespace StudentManagement.Validations
{
    public class AgeGreaterThan : ValidationAttribute
    {
        public int Age { get; set; }
        public AgeGreaterThan(int age, string? errorMessage) : base()
        {
            Age = age;
            ErrorMessage = errorMessage ?? "";
        }        
        public override string FormatErrorMessage(string name)
        {
            return string.IsNullOrEmpty(ErrorMessage) ? 
                $"Age must be bigger than or equal {Age}" : ErrorMessage ;
        }


        public override bool IsValid(object? value)
        {                                   
            return new DateTime((DateTime.Now - (DateTime)value).Ticks).Year >= Age;            
        }

        /*
        protected override ValidationResult? IsValid(object? value, ValidationContext validationContext)
        {
            return null;
        }
        */
    }
}
