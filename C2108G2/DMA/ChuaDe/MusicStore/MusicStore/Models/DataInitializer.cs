using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace MusicStore.Models
{
    public class DataInitializer: DropCreateDatabaseIfModelChanges<DataContext>
    {
        protected override void Seed(DataContext context)
        {
            base.Seed(context);
            if (!context.Albums.Any() || !context.Genres.Any()) {
                context.Genres.AddRange(new List<Genre>
                {
                    new Genre { GenreId = 1, GenreName = "Pop" },
                    new Genre { GenreId = 2, GenreName = "Rock" },
                    new Genre { GenreId = 3, GenreName = "Hip Hop" },
                    new Genre { GenreId = 4, GenreName = "Jazz" },
                    new Genre { GenreId = 5, GenreName = "Punk" },
                    new Genre { GenreId = 6, GenreName = "Rap" },
                    new Genre { GenreId = 7, GenreName = "R&B" },
                    new Genre { GenreId = 8, GenreName = "Country" },
                    new Genre { GenreId = 9, GenreName = "Latin" }
                });
                var albums = new List<Album>
                    {
                        new Album { AlbumId = 1, Title = "Twenty File", ReleaseDate = DateTime.Parse("2015-11-20"), Artist = "Adele", GenreId = 1, Price = 9.99 },
                        new Album { AlbumId = 2, Title = "Nineteen Eighty-Nine", ReleaseDate = DateTime.Parse("2014-10-27"), Artist = "Taylor Swift", GenreId = 1, Price = 10.99 },
                        new Album { AlbumId = 3, Title = "A million", ReleaseDate = DateTime.Parse("2016-09-30"), Artist = "Bon Iver", GenreId = 2, Price = 9.99 },
                        new Album { AlbumId = 4, Title = "Meteora", ReleaseDate = DateTime.Parse("2003-03-25"), Artist = "Linkin Park", GenreId = 2, Price = 7.99 },
                        new Album { AlbumId = 5, Title = "Nevermind", ReleaseDate = DateTime.Parse("1991-09-24"), Artist = "Nivarna", GenreId = 2, Price = 9.99 },
                        new Album { AlbumId = 6, Title = "To Pimp a Butterfly", ReleaseDate = DateTime.Parse("2015-03-15"), Artist = "Kendrick Lamar", GenreId = 3, Price = 8.99 },
                        new Album { AlbumId = 7, Title = "The Chronic", ReleaseDate = DateTime.Parse("1992-12-15"), Artist = "Dr. Dre", GenreId = 3, Price = 9.99 },
                        new Album { AlbumId = 8, Title = "Comes Away With Me", ReleaseDate = DateTime.Parse("2002-02-26"), Artist = "Norah Jones", GenreId = 4, Price = 6.99 },
                        new Album { AlbumId = 9, Title = "Kind of Blues", ReleaseDate = DateTime.Parse("1959-08-17"), Artist = "Miles Davis", GenreId = 4, Price = 7.99 },
                        new Album { AlbumId = 10, Title = "Dookie", ReleaseDate = DateTime.Parse("1994-02-01"), Artist = "Green Day", GenreId = 5, Price = 8.99 },
                        new Album { AlbumId = 11, Title = "Relapse", ReleaseDate = DateTime.Parse("2009-05-15"), Artist = "Eminem", GenreId = 6, Price = 9.99 },
                        new Album { AlbumId = 12, Title = "Get Rich or Die", ReleaseDate = DateTime.Parse("2003-02-06"), Artist = "Tryin", GenreId = 6, Price = 7.99 },
                        new Album { AlbumId = 13, Title = "Blonde", ReleaseDate = DateTime.Parse("2016-08-20"), Artist = "Frank Oceans", GenreId = 7, Price = 8.99 },
                        new Album { AlbumId = 14, Title = "Love, Marriage & Divorce", ReleaseDate = DateTime.Parse("2014-02-04"), Artist = "Babyface & Toni Braxton", GenreId = 7, Price = 9.99 },
                        new Album { AlbumId = 15, Title = "Lemonade", ReleaseDate = DateTime.Parse("2016-04-23"), Artist = "Beyonce", GenreId = 1, Price = 11.99 },
                        new Album { AlbumId = 16, Title = "Purpose", ReleaseDate = DateTime.Parse("2015-11-13"), Artist = "Justin Bieber", GenreId = 1, Price = 9.99 },
                        new Album { AlbumId = 17, Title = "Los Duo", ReleaseDate = DateTime.Parse("2015-02-10"), Artist = "Joan Gabriel", GenreId = 9, Price = 7.99 },
                        new Album { AlbumId = 18, Title = "They Don’t KNow", ReleaseDate = DateTime.Parse("2016-09-09"), Artist = "Jason Aldean", GenreId = 9, Price = 9.99 }
                    };
                context.Albums.AddRange(albums);
                context.SaveChanges();
            }
        }
    }
}