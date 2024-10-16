using System;
using System.ComponentModel.DataAnnotations;

namespace de01.Models
{
    public class DiplomaType
    {
        [Key]
        public int DiplomaTypeID { get; set; }

        [Required(ErrorMessage = "Diploma type name is required")]
        [StringLength(255, ErrorMessage = "Diploma type name cannot be longer than 255 characters")]
        public string DilomaTypeName { get; set; }

        [StringLength(255, ErrorMessage = "Organization issue cannot be longer than 255 characters")]
        public string OrganizationIssue { get; set; }

        [StringLength(255, ErrorMessage = "Person issue cannot be longer than 255 characters")]
        public string PersonIssue { get; set; }

        [StringLength(255, ErrorMessage = "Position cannot be longer than 255 characters")]
        public string Position { get; set; }

        [StringLength(50, ErrorMessage = "Language cannot be longer than 50 characters")]
        public string Language { get; set; }

        [StringLength(50, ErrorMessage = "Colour cannot be longer than 50 characters")]
        public string Colour { get; set; }

        [StringLength(50, ErrorMessage = "Size cannot be longer than 50 characters")]
        public string Size { get; set; }

        public ICollection<Diploma> Diplomas { get; set; }
    }

}

