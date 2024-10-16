using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Web;

namespace EAP_C2009G_NguyenVanA.Models
{
    public class DataInitializer : DropCreateDatabaseIfModelChanges<DataContext>
    {
        public void CreateFakeData(DataContext context) {
            this.Seed(context);
        }
        protected override void Seed(DataContext context)
        {
            Console.WriteLine("Begin seeding..");
            base.Seed(context);
            context.Genres.AddRange(new List<Genre>
            {
                new Genre { GenreId = 1, GenreName = "Science Fiction Film" },
                new Genre { GenreId = 2, GenreName = "Romantic Disaster Film" },
                new Genre { GenreId = 3, GenreName = "Opera Film" },
                new Genre { GenreId = 4, GenreName = "Super Hero Film" },
                new Genre { GenreId = 5, GenreName = "Action Film" },
                new Genre { GenreId = 6, GenreName = "3D Animated Feature Film" },
                new Genre { GenreId = 7, GenreName = "Musical" }
            });            
            context.SaveChanges();
            context.Movies.AddRange(new List<Movie>
            {
                new Movie {MovieId=01, Title="Avatar", ReleaseDate=DateTime.Parse("2009-12-10"), RunningTime=161, GenreId= 1, BoxOffice = 2.788f},
                new Movie {MovieId=02, Title="Titanic", ReleaseDate=DateTime.Parse("1997-11-01"), RunningTime=195, GenreId=2, BoxOffice = 2.187f},
                new Movie {MovieId=03, Title="Star Wars: The Force Awakens", ReleaseDate=DateTime.Parse("2015-12-14"), RunningTime=135, GenreId=3, BoxOffice=1.763f},
                new Movie {MovieId=04, Title="Jurassic World", ReleaseDate=DateTime.Parse("2015-05-29"), RunningTime=124, GenreId=1, BoxOffice=1.669f},
                new Movie {MovieId=05, Title="Marvel Avengers", ReleaseDate=DateTime.Parse("2012-04-11"), RunningTime=143, GenreId=4, BoxOffice= 1.520f},
                new Movie {MovieId=06, Title="Fast And Furius", ReleaseDate=DateTime.Parse("2015-04-11"), RunningTime=137, GenreId=5, BoxOffice= 1.515f},
                new Movie {MovieId=07, Title="Frozen", ReleaseDate=DateTime.Parse("2013-11-19"), RunningTime=102, GenreId=6, BoxOffice = 1.276f},
                new Movie {MovieId=08, Title="Iron Man 3", ReleaseDate=DateTime.Parse("2013-05-03"), RunningTime=130, GenreId=4, BoxOffice=1.215f},
                new Movie {MovieId=09, Title="Minions", ReleaseDate=DateTime.Parse("2015-06-11"), RunningTime=91, GenreId=6, BoxOffice=1.157f},
                new Movie {MovieId=10, Title="Transformers", ReleaseDate=DateTime.Parse("2007-06-12"), RunningTime=144, GenreId=1, BoxOffice=0.71f},
                new Movie {MovieId=11, Title="High School Musical", ReleaseDate=DateTime.Parse("2016-01-20"), RunningTime=98, GenreId=7, BoxOffice = 0.4f},
                new Movie {MovieId=12, Title="Gangnam Style", ReleaseDate=DateTime.Parse("2007-06-12"), RunningTime=93, GenreId=7, BoxOffice=0.5f}                                
            });
            context.SaveChanges();
            Console.WriteLine("End seeding..");
        }
    }
}