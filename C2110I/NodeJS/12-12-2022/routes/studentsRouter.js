const express = require('express')
const router = express.Router()
const {studentsController} = require('../controllers')

router.get('/',         studentsController.getAllStudents)
router.get('/:id',      studentsController.getStudentById)
router.patch('/:id',    studentsController.updateStudent)
router.post('/',        studentsController.insertStudent)

module.exports = router