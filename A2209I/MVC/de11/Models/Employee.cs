using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace de11.Models
{
    public class Employee
    {
        [Key]
        public int EmpID { get; set; }
        public string EmpName { get; set; }

        

        [ForeignKey("Department")]
        public int DeptID { get; set; }
        public virtual Department Department { get; set; }
    }
}
