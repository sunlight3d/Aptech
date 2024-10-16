using System;
using System.ComponentModel.DataAnnotations;

namespace de01.Models
{
    public class TrainingType
    {
        [Key]
        public int TrainingTypeID { get; set; }

        [StringLength(50, ErrorMessage = "Training type code cannot be longer than 50 characters")]
        public string TrainingTypeCode { get; set; }

        [StringLength(255, ErrorMessage = "Training type name cannot be longer than 255 characters")]
        public string TrainingTypeName { get; set; }

        public ICollection<TrainingProgram> TrainingPrograms { get; set; }
    }
}

