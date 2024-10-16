using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2009G_NguyenVanA
{
    public class AlbumController: ApiController
    {
        private List<Album> list; //field
        public AlbumController() {
            this.list = new List<Album>() { 
              new Album {Title = "Come Away With Me", Genre = "Jazz", Price = 12.9f},
              new Album {Title = "The BluePrint", Genre = "Hip Hop", Price = 15.5f},
              new Album {Title = "Unconditional", Genre = "Hard Rock", Price = 10.9f},
            };
        }
        public IHttpActionResult Get() {
            return Ok(list);
        }
        public Album Get(int i) {
            return list[i] ?? new Album();
        }
        public void Post(Album album) {
            list.Add(album);
            Console.WriteLine("haha");            
        }
        public void Put(int id, Album item)
        {
            Album existingAlbum = list[id];
            if (existingAlbum != null) {
                existingAlbum.Title = item.Title ?? existingAlbum.Title;
                existingAlbum.Genre = item.Genre ?? existingAlbum.Genre;
                existingAlbum.Price = item.Price == 0 ? existingAlbum.Price : item.Price;
            }
        }
        public void Delete(int id) {
            list.RemoveAt(id);
        }
    }
}
