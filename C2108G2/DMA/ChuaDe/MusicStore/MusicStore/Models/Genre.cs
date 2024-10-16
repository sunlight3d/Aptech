using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace MusicStore.Models
{
    public class Genre
    {
        public int GenreId { get; set; }
        [Required]
        public string GenreName { get; set; }

        public virtual ICollection<Album> Albums { get; set; }
        public Genre() {
            Albums = new HashSet<Album>();
        }
    }
}