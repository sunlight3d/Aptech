const express = require('express');
const router = express.Router();
const { validationResult } = require('express-validator');
const studentController = require('../controllers/studentController');
const {emailValidation, nameValidation} = require('../validations/inputValidations');

//curl -i http://localhost:3001/students
router.get('/', studentController.getStudents);
router.get('/:id', (req, res) => {
    //curl -i http://localhost:3001/students
    debugger
    res.json({
      message: 'Chao ban, day la danh sach student'
    });
  });
  router.get('/:id/classes', (req, res) => studentController.getStudentById);


/**
curl -i -X POST http://localhost:3001/students \
  -H "Content-Type: application/json" \
  -d '{"name": "John Doe", "age": 20, "phone_number": "11223344", "email": "hdhd"}'
*/  
  router.post('/', 
    emailValidation,   
    nameValidation,      
    (req, res) => {      
      const result = validationResult(req);
      if (result.isEmpty()) {        
       //if validation is ok, call controller's function
       return studentController.createStudent(req, res);       
      }    
      res.send({ errors: result.array() });                  
});
router.put('/:id', (req, res) => studentController.updateStudent);
router.delete('/', (req, res) => studentController.deleteStudent);

module.exports = router;
