using System.ComponentModel.DataAnnotations;

namespace myapp.ViewModels
{
    public class AddEmployeeViewModel
    {
        [Required(ErrorMessage ="Please enter employee No")]
        public int EmployeeNo { get; set; }
        [Required(ErrorMessage = "Please enter employee Name")]
        public string EmployeeName { get; set; }
        [Required(ErrorMessage = "Please enter place of work")]
        public int DepartmentId { get; set; }
        public int Age { get; set; }
        public string Sex { get; set; }

        /*
        public string PlaceOfWork { get; set; }
        [Required(ErrorMessage = "Please enter Phone")]
        public string PhoneNo { get; set; }
        */
    }
}

