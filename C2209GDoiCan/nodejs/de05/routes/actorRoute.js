const express = require('express');
const router = express.Router();
const actorController = require('../controllers/actorController');
const { query, body, validationResult } = require('express-validator');

router.post('/',     
    body('first_name').notEmpty(),      
    body('last_name').notEmpty(),      
    (req, res) => {      
      const result = validationResult(req);
      if (result.isEmpty()) {               
       return actorController.createActor(req, res);       
      }    
      res.send({ errors: result.array() });                  
});

router.get('/', actorController.getActors);//no validation
router.get('/:id', actorController.getActorById);

//GET /api/actors/:id/movies: Get a list of movies for an actor by ID (2 points).
//router.get('/:id/movies', movieController.getMovieForAnActor);


module.exports = router;