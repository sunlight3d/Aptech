const getConnection = require('../db/db');

const createMovie = async (req, res) => {    
    const { title, year, time, release_date, country } = req.body;    
    const connection = await getConnection()    
    try {      
      const result = await connection.execute(
          'INSERT INTO movies(title, year, time, release_date, country) VALUES(?, ?, ?, ?, ?)',
          [title, year, time, release_date, country]
      );
      console.log('Movie inserted successfully');
      res.status(201).json({
        message: 'Insert successfully',        
        data: result
      });
    } catch (error) {        
        console.error('Error inserting movie:', error);
        res.status(400).json({
          message: error?.message ?? "",
          code: error.code
        });
    } finally {
        // Release the connection back to the pool
        connection.release();
    }    
};

// Controller functions
const getMovies = async (req, res) => {
  const connection = await getConnection();
  debugger
  try {
      const [rows] = await connection.execute('SELECT * FROM movies');
      res.status(200).json({
          message: 'Successfully fetched all movies',
          data: rows
      });
  } catch (error) {
      debugger
      console.error('Error fetching movies:', error);
      res.status(500).json({
          message: error?.message ?? "Error fetching movies",
          code: error.code
      });
  } finally {
      // Release the connection back to the pool
      connection.release();
  }
};


const getMovieById = async (req, res) => {
  const { id } = req.params;
  const connection = await getConnection();
  try {
      const [rows] = await connection.execute('SELECT * FROM movies WHERE id = ?', [id]);
      if (rows.length === 0) {
          return res.status(404).json({ error: 'Movie not found' });
      }
      res.status(200).json({
          message: 'Successfully fetched movie by ID',
          data: rows[0]
      });
  } catch (error) {
      console.error('Error fetching movie by ID:', error);
      res.status(500).json({
          message: error?.message ?? "Error fetching movie by ID",
          code: error.code
      });
  } finally {
      // Release the connection back to the pool
      connection.release();
  }
}



const updateMovie = async (req, res) => {
  const { id } = req.params;
  const { title, year, time, release_date, country } = req.body;
  const connection = await getConnection();
  try {
      const result = await connection.execute(
          'UPDATE movies SET title = ?, year = ?, time = ?, release_date = ?, country = ? WHERE id = ?',
          [title, year, time, release_date, country, id]
      );
      res.status(200).json({
          message: 'Successfully updated movie',
          data: result
      });
  } catch (error) {
      console.error('Error updating movie:', error);
      res.status(500).json({
          message: error?.message ?? "Error updating movie",
          code: error.code
      });
  } finally {
      // Release the connection back to the pool
      connection.release();
  }
};

const deleteMovie = async (req, res) => {
  const { id } = req.params;
  const connection = await getConnection();
  try {
      const result = await connection.execute('DELETE FROM movies WHERE id = ?', [id]);
      res.status(200).json({
          message: 'Successfully deleted movie',
          data: result
      });
  } catch (error) {
      console.error('Error deleting movie:', error);
      res.status(500).json({
          message: error?.message ?? "Error deleting movie",
          code: error.code
      });
  } finally {
      // Release the connection back to the pool
      connection.release();
  }
};
//router.get('/:movie_id/actors/:actor_id', movieController.addAnActorToAMovie);
const addAnActorToAMovie = async (req, res) => {
    
    const { movie_id, actor_id  } = req.params;
    const {role} = req.body;
    debugger
    const connection = await getConnection();
    try {
        //insert into movie_casts(actor_id, movie_id, role) values(1, 2, 'abc')

        const result = await connection.execute(
            'insert into movie_casts(actor_id, movie_id, role) values(?, ?, ?)', 
            [actor_id, movie_id, role]);
        res.status(200).json({
            message: 'Successfully update movie_casts',
            data: result
        });
    } catch (error) {        
        res.status(500).json({
            message: error?.message ?? "Error changing movie_casts",
            code: error.code
        });
    } finally {
        // Release the connection back to the pool
        connection.release();
    }
  };

module.exports = {
    getMovies,
    getMovieById,
    createMovie,
    updateMovie,
    deleteMovie,
    addAnActorToAMovie,
};
/*
insert into movies(title, year, time, release_date, country) 
values('Di choi thoi', 2024, 120,'2024-12-02', 'vn');

insert into movies(title, year, time, release_date, country) 
values('dsmfkdf', 2023, 120,'2023-05-02', 'uk');

insert into movie_casts(actor_id, movie_id, role) values(1, 2, 'abc');

*/