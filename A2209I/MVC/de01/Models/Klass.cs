using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
namespace de01.Models
{    
    [Table("Class")]
    public class Klass
    {
        [Key]
        [DatabaseGenerated(DatabaseGeneratedOption.Identity)]
        [Column("ClassId")]
        public int Id { get; set; }

        [Required]
        [StringLength(100, ErrorMessage = "Class name cannot be longer than 100 characters.")]
        public string ClassName { get; set; }
    }

}
