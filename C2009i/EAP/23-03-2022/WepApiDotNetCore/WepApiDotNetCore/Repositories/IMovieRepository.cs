using WepApiDotNetCore.Models;

namespace WepApiDotNetCore
{
    public interface IMovieRepository
    {
        public IEnumerable<Movie> GetMovies();
        public Movie? Get(int id);
        
        public void Add(Movie movie);
        public void Update(Movie movie);

    }
}
