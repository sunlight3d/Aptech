using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace EAP_Music_NguyenVanA.Models
{
    public class Album
    {
        public int AlbumId { get; set; }
        public string AlbumTitle { get; set; }
        public DateTime ReleaseDate { get; set; }
        public string Artist { get; set; }
        public double Price { get; set; }
        public int GenreId { get; set; }
        public virtual Genre Genre {get; set;}
    }
}