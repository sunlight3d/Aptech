import express from 'express'
const router = express.Router()
import { studentsController } from '../controllers/index.js'

router.get('/',         studentsController.getAllStudents)
router.get('/:id',      studentsController.getStudentById)
router.patch('/:id',    studentsController.updateStudent)
router.post('/',        studentsController.insertStudent)

export default router