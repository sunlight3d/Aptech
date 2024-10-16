using Owin_C1908G_NguyenVanA.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Owin_C1908G_NguyenVanA.Repositories
{
    public class Fakesongs
    {
        public static List<Song> fakesongs = new List<Song>()
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
}
