using System.ComponentModel.DataAnnotations;

namespace myWebApp.ViewModels
{
    public class StudentViewModel
    {
        [Required] //Annotation(Attribute)
        [StringLength(200, MinimumLength = 5, 
            ErrorMessage ="Name must be at least 5 chars")]
        //validation in ViewModel
        public String StudentName { get; set; }
    }
}
