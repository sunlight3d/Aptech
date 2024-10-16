using Owin_C2009i_NguyenVanA.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2009i_NguyenVanA.Controllers
{
    public class AlbumController : ApiController
    {
        private List<Album> albums = new List<Album>();
        public AlbumController()
        {
            albums = new List<Album>() {
                new Album() {
                    Title = "Come Away With Me", Genre = "Jazz", Price = 12.9
                },
                new Album() {
                    Title = "The BluePrint", Genre = "Hip Hop", Price = 15.5
                },
                new Album() {
                    Title = "Unconditional", Genre = "Hard Rock", Price = 10.9
                }
            };
        }
        // GET api/values 
        public IHttpActionResult Get()
        {
            return Ok(albums);
        }

        // GET api/values/5 
        public Album Get(int id)
        {
            return albums
                    .Where(album => id == album.Id)
                    .FirstOrDefault();
        }

        // POST api/values 
        public void Post([FromBody] Album album)
        {
            var existingAlbum = albums
                .Where(item => item.Title.Equals(album.Title) && item.Genre.Equals(album.Genre))
                .FirstOrDefault();
            if (existingAlbum == null)
            {
                albums.Add(album);
            }

        }

        // PUT api/values/5 
        public void Put(int id, [FromBody] Album album)
        {
            var existingAlbum = albums
                .Where(item => item.Id == id)
                .FirstOrDefault();
            if (existingAlbum != null)
            {
                existingAlbum.Title = album.Title == null ? existingAlbum.Title : album.Title;
                existingAlbum.Genre = album.Genre == null ? existingAlbum.Genre : album.Genre;
                existingAlbum.Price = album.Price;
            }
        }

        // DELETE api/values/5 
        public void Delete(int id)
        {
            var existingAlbum = albums
                .Where(item => item.Id == id)
                .FirstOrDefault();
            if (existingAlbum != null)
            {
                albums.Remove(existingAlbum);
            }

        }
    }
}
