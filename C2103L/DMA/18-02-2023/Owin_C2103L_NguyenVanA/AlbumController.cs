using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C2103L_NguyenVanA
{
    public class AlbumController: ApiController
    {
        private List<Album> albumList;
        public AlbumController() { 
            this.albumList = new List<Album>() {
                new Album {Genre = "Jazz", Price = 12.9, Title = "Come Away With Me"},
                new Album {Title = "The BluePrint", Genre = "Hip Hop", Price = 15.5},
                new Album {Title = "Unconditional", Genre = "Hard Rock", Price = 10.9}
            };
        }
        public IHttpActionResult Get() {
            if (albumList.Count == 0) { 
                return NotFound();
            }
            return Ok(albumList);
        }
        public Album Get(int id) {
            try { 
                return albumList[id];
            }catch(Exception ex)
            {
                return new Album();
            }
        }
        public void Post(Album item) { 
            albumList.Add(item);
        }
        public void Put(int id, Album item) { 
            Album selectedAlbum = albumList[id];
            selectedAlbum.Title = string.IsNullOrEmpty(item.Title) ? item.Title : selectedAlbum.Title;
            selectedAlbum.Genre = string.IsNullOrEmpty(item.Genre) ? item.Genre : selectedAlbum.Genre;
            selectedAlbum.Price = item.Price > 0 ? item.Price : selectedAlbum.Price;
        }
        public void Delete(int id) {            
            Album selectedAlbum = albumList[id];
            albumList.Remove(selectedAlbum);
        }


    }
}
