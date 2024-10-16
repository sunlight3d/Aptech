using System;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;

namespace de01.Models
{
    public class Diploma
    {
        [Key]
        public int DiplomaID { get; set; }

        [Required(ErrorMessage = "Full name is required")]
        [StringLength(60, ErrorMessage = "Full name cannot be longer than 60 characters")]
        public string FullName { get; set; }

        [Required(ErrorMessage = "Date of birth is required")]
        public DateTime DOB { get; set; }

        [ForeignKey("Sex")]
        public int SexID { get; set; }
        public Sex Sex { get; set; }

        [ForeignKey("TrainingType")]
        public int TrainingTypeID { get; set; }
        public TrainingType TrainingType { get; set; }

        [ForeignKey("TrainingProgram")]
        public int TrainingProgramID { get; set; }
        public TrainingProgram TrainingProgram { get; set; }

        [ForeignKey("Rank")]
        public int RankID { get; set; }
        public Rank Rank { get; set; }

        [ForeignKey("DiplomaType")]
        public int DiplomaTypeID { get; set; }
        public DiplomaType DiplomaType { get; set; }

        [StringLength(100, ErrorMessage = "Birth place cannot be longer than 100 characters")]
        public string BirthPlace { get; set; }

        [StringLength(20, ErrorMessage = "Volumed book cannot be longer than 20 characters")]
        public string VolumedBook { get; set; }

        [StringLength(30, ErrorMessage = "Decide code cannot be longer than 30 characters")]
        public string DecideCode { get; set; }

        [StringLength(30, ErrorMessage = "Number sign cannot be longer than 30 characters")]
        public string NumberSign { get; set; }

        [StringLength(30, ErrorMessage = "Register number cannot be longer than 30 characters")]
        public string RegisterNumber { get; set; }

        [StringLength(30, ErrorMessage = "Language cannot be longer than 30 characters")]
        public string Language { get; set; }

        [StringLength(30, ErrorMessage = "Colour cannot be longer than 30 characters")]
        public string Colour { get; set; }

        [StringLength(30, ErrorMessage = "Size cannot be longer than 30 characters")]
        public string Size { get; set; }
    }
}

