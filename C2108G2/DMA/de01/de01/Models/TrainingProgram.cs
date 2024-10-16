using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace de01.Models
{
    public class TrainingProgram
    {
        [Key]
        public int TrainingProgramID { get; set; }

        [StringLength(255, ErrorMessage = "Training program name cannot be longer than 255 characters")]

        [Column("TrainingProgram")]
        public string TrainingProgramName { get; set; }

        public float? MaxPoint { get; set; }

        public float? AchievePoint { get; set; }

        public int? Achieve { get; set; }

        public int? TrainingTypeID { get; set; }

        public TrainingType TrainingType { get; set; }

        public ICollection<Diploma> Diplomas { get; set; }
    }
}

