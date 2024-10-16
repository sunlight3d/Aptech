using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EAP_Music_NguyenVanA.Models
{
    public class Genre
    {
        public int GenreId { get; set; }
        public string GenreName { get; set; }
        public virtual ICollection<Album> Albums;
        public Genre() {
            this.Albums = new HashSet<Album>();
        }
    }
}