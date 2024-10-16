using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace EAP_C2009G_NguyenVanA.Models
{
    public class Movie
    {
        [Key]
        public int MovieId { get; set; }
        [Required]
        [StringLength(32, MinimumLength =3, ErrorMessage ="Must be 3 to 32")]
        public string Title { get; set; }
        [Required]
        [DataType(DataType.DateTime)]
        public DateTime ReleaseDate { get; set; }
        [Required]
        [Range(60, 240)]
        public int RunningTime { get; set; }
        [Required]
        [Range(0, float.MaxValue)]
        public float BoxOffice { get; set; }
        //foreign key
        public int GenreId { get; set; }
        public virtual Genre Genre { get; set; }
    }
}