using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2110i_NguyenVanA
{
    public class AlbumsController : ApiController
    {
        // GET api/values 
        private List<Album> albums = new List<Album> {

             new Album {Title = "Come Away With Me", Genre = "Jazz", Price = 12.9},
             new Album {Title = "The BluePrint", Genre = "Hip Hop", Price = 15.5},
             new Album {Title = "Unconditional", Genre = "Hard Rock", Price = 10.9},
        };
        public IEnumerable<Album> Get()
        {
            return this.albums;

        }

        // GET api/values/5 
        public Album Get(int id)
        {
            if (id < 0 || id > albums.Count - 1) {
                throw new Exception("Exceed length of albums");
            }
            return albums[id];
        }

        // POST api/values 
        public void Post([FromBody] Album album)
        {
            albums.Add(album);
        }


        // PUT api/values/5 
        public void Put(int id, [FromBody] Album album)
        {
            if (id < 0 || id > albums.Count - 1)
            {
                throw new Exception("Exceed length of albums");
            }
            Album selectedAlbum = albums[id];
            selectedAlbum.Title = album.Title ?? selectedAlbum.Title;
            selectedAlbum.Genre = album.Genre ?? selectedAlbum.Genre;
            selectedAlbum.Price = selectedAlbum.Price;

        }

        // DELETE api/values/5 
        public void Delete(int id)
        {
        }
    }
}
