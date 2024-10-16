const express = require('express')
const router = express.Router()
const {usersController} = require('../controllers')

//POST localhost:3002/users/login
router.post('/login', usersController.login)
router.post('/register', usersController.register)

module.exports = router