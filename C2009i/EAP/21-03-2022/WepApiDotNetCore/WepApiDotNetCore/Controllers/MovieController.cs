using Microsoft.AspNetCore.Mvc;
using WepApiDotNetCore.Models;
using WepApiDotNetCore.Repositories;

namespace WepApiDotNetCore.Controllers
{
    //: ControllerBase => from .NET core Web Api
    //ApiController => .Net Web Api
    
    [ApiController]    
    [Route("[controller]")]
    public class MovieController : ControllerBase
    {
        private readonly Logger<MovieController> _logger;
        private IMovieRepository _movieRepository = new MovieRepository();
        //inject to constructor
        //logger object already exists
        public MovieController(ILogger<MovieController> logger) {
            _logger = (Logger<MovieController>?)logger;
        }
        
        [HttpGet(Name = "GetMovies")]
        public IEnumerable<Movie> GetMovies() {
            return _movieRepository.GetMovies();   
        }

        [HttpGet("{id}")]
        public ActionResult<Movie> Get(int id)
        {
            var movie = _movieRepository.Get(id);
            return movie == null ? NotFound() : movie;            
        }

        [HttpPost]
        public IActionResult Create(Movie movie)
        {
            _movieRepository.Add(movie);
            return CreatedAtAction(nameof(Create), new { id = movie.Id }, movie);
        }    
        [HttpPut("{id}")]
        public IActionResult Update(int id, Movie movie)
        {
            //movie is in "body"
            // This code will update the pizza and return a result
            if (id != movie.Id)
                return BadRequest();

            var existingPizza = PizzaService.Get(id);
            if (existingPizza is null)
                return NotFound();

            PizzaService.Update(pizza);

            return NoContent();
            return Ok();
        }
        [HttpDelete("{id}")]
        public IActionResult Delete(int id)
        {
            // This code will delete the pizza and return a result
            return Ok();
        }
    }
}
