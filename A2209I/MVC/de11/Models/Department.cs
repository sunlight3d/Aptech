using System.ComponentModel.DataAnnotations;

namespace de11.Models
{
    public class Department
    {
        [Key]
        public int DeptID { get; set; }
        [Required]
        public string DeptName { get; set; }
    }
}
