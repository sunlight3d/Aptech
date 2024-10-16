const express = require('express');
const router = express.Router();
const klassController = require('../controllers/klassController');
const {emailValidation, nameValidation} = require('../validations/inputValidations');
const { validationResult } = require('express-validator');

router.get('/', klassController.getKlasses);//no validation
router.get('/:id', klassController.getKlassById);

router.get('/:id/students', (req, res) => {
    //curl -i http://localhost:3001/classes
  debugger
  return klassController.getKlasses();  
});
router.post('/',     
    nameValidation,      
    (req, res) => {      
      const result = validationResult(req);
      if (result.isEmpty()) {        
       //if validation is ok, call controller's function
       return klassController.createKlass(req, res);       
      }    
      res.send({ errors: result.array() });                  
});

router.put('/:id', klassController.updateKlass); 

router.post('/:id/classes/:id', (req, res) => {
    //curl -i http://localhost:3001/classes
    debugger
    res.json({
        message: 'This is post'
    });
});

router.delete('/', klassController.deleteKlass);

module.exports = router;
