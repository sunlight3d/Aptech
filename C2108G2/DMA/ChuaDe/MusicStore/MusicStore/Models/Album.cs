using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MusicStore.Models
{
    public class Album
    {
        public int AlbumId { get; set; }
        
        [Required]
        [StringLength(32, MinimumLength =3, ErrorMessage ="Title must be 3 to 32 in lenth")]
        public string Title { get; set; }
        [Required]
        [DataType(DataType.DateTime)]
        public DateTime ReleaseDate { get; set; }
        [Required]
        public string Artist { get; set; }
        [Required]
        [Range(1, 15, ErrorMessage = "Price must be 1 to 15")]
        public double Price { get; set; }

        public int GenreId { get; set; }
        public virtual Genre Genre { get; set; }
    }
}