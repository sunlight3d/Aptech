const express = require('express');
const router = express.Router();
const movieController = require('../controllers/movieController');

const { query, body, validationResult } = require('express-validator');
//const emailValidation = body('email').optional().trim().isEmail();  
//const nameValidation = body('name').notEmpty();

router.get('/', movieController.getMovies);//no validation
router.get('/:id', movieController.getMovieById);
router.put('/:id', movieController.updateMovie);
router.delete('/:id', movieController.deleteMovie);

router.post('/',     
    body('title').notEmpty(),      
    (req, res) => {      
      const result = validationResult(req);
      if (result.isEmpty()) {               
       return movieController.createMovie(req, res);       
      }    
      res.send({ errors: result.array() });                  
});
//router.get('/:id/actors', movieController.getActorsForAMovie);
router.post('/:movie_id/actors/:actor_id', movieController.addAnActorToAMovie);
module.exports = router;
