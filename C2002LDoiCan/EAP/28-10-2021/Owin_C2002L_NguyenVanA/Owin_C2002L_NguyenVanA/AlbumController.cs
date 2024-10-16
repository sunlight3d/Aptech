using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2002L_NguyenVanA
{
    class AlbumController:ApiController
    {
        private List<Album> list = new List<Album>() {
            new Album() {Title = "Come Away With Me", Genre = "Jazz", Price = 12.9},
            new Album()   {Title = "The BluePrint", Genre = "Hip Hop", Price = 15.5},
            new Album() {Title = "Unconditional", Genre = "Hard Rock", Price = 10.9},
        };
        public IHttpActionResult Get() {
            return Ok(list);
        }
        public Album Get(int id)
        {
            return list.Where(album => album.Id == id).FirstOrDefault();
        }
        public void Post(Album item)
        {
            list.Add(item);
        }
        public void Put(int id, Album item)
        {
            Album selectedAlbum = list.Where(album => album.Id == id)
                .FirstOrDefault();
            if (selectedAlbum != null) {
                selectedAlbum.Title = item.Title;
                selectedAlbum.Genre = item.Genre;
                selectedAlbum.Price = item.Price;
            }
        }
        public void Delete(int id)
        {
            Album selectedAlbum = list.Where(album => album.Id == id)
                .FirstOrDefault();
            if (selectedAlbum != null)
            {
                list.Remove(selectedAlbum);
            }
        }
    }
}
