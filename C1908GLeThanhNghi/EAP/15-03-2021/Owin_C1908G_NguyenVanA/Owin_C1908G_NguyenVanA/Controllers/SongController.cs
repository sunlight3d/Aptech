using Owin_C1908G_NguyenVanA.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web.Http;

namespace Owin_C1908G_NguyenVanA.Controllers
{
    public class SongController: ApiController
    {
        private List<Song> songs;
        public SongController() {            
            songs = new List<Song>()
            {
                new Song(){                    
                    Title = "Hey Jude",
                    Artist = "The Beatles",
                    Price = 1.5
                },
                new Song(){
                    Title = "I got",
                    Artist = "The black",
                    Price = 1.9
                },
                new Song(){
                    Title = "The twist",
                    Artist = "chubby",
                    Price = 2.0
                }
            };
        }
        public IEnumerable<Song> Get() {
            //co the gui request qua trinh duyet: Chrome, gui qua Postman, Colab
            return this.songs;
        }
        public Song Get(int i) {
            return this.songs[i];
        }

        public void Post(Song item) {
            //validate, ko can if, else tung thuoc tinh
            if (ModelState.IsValid) {
                this.songs.Add(item);
            }
        }
        [HttpPut]
        public void Put(int i, Song item)
        {
            Song selectedSong = this.songs[i];
            if (selectedSong == null) {
                return;
            }
            selectedSong.Title = item.Title ?? selectedSong.Title;//nil-coelescing 
            selectedSong.Artist = item.Artist ?? selectedSong.Artist;
            selectedSong.Price = item.Price > 0 ? item.Price : selectedSong.Price;
        }
        [HttpDelete]
        public void Delete(int i)
        {
            Song selectedSong = this.songs[i];
            this.songs.Remove(selectedSong);
        }
    }
}
