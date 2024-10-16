using System.ComponentModel.DataAnnotations.Schema;
using System.ComponentModel.DataAnnotations;

namespace _03_07_2023.Models
{
    [Table("Department")]
    public class Department
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]        
        public int DepartmentId { get; set; }

        [Required]
        [MaxLength(255)]
        public string DepartmentName { get; set; }
    }
}
