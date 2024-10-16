using WepApiDotNetCore.Models;

namespace WepApiDotNetCore.Repositories
{
    public class MovieRepository:IMovieRepository
    {
        private readonly List<Movie> movies = new List<Movie>{
                new Movie { Id = 1,Title="Star War", Year = 1977 },
                new Movie { Id = 1,Title="Back to the Future", Year = 1985 },
                new Movie { Id = 1,Title="The Matrix", Year = 1999 },
                new Movie { Id = 1,Title="Inception", Year = 2010 },
                new Movie { Id = 1,Title="Interstellar", Year = 2014 },
        };
        public IEnumerable<Movie> GetMovies()
        {
            return movies;
        }
        public Movie? Get(int id) => movies
            .Where(movie => movie.Id == id)
            .FirstOrDefault();
        public void Add(Movie movie)
        {
            movies.Add(movie);
        }
        public void Update(Movie movie) {
            Movie? selectedMovie = movies.Where(m => m.Id == movie.Id).FirstOrDefault();
            if (selectedMovie != null) { 
                selectedMovie.Title = movie.Title ?? selectedMovie.Title;
                selectedMovie.Year = movie.Year == 0 ? selectedMovie.Year : movie.Year;
            }
        }
    }
}
