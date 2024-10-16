using System.ComponentModel.DataAnnotations;

namespace de11.ViewModels
{
    public class EmployeeViewModel
    {
        public int EmployeeNo { get; set; }
        public string EmployeeName { get; set; }
        public string Position { get; set; }
        public int Salary { get; set; }
    }    
}
