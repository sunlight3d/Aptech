import express from 'express'
const router = express.Router()
import { usersController } from '../controllers/index.js'

//POST localhost:3002/users/login
router.post('/login', usersController.login)
router.post('/register', usersController.register)

export default router