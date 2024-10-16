const { response } = require('express')
const express = require('express')
const router = express.Router()
const User = require('../models/user')
const { body, validationResult } = require('express-validator')

//config enpoints
//http://localhost:3001/users
router.get('/:userId', (request, response) => {
    const userId = request.params.userId != null ? parseInt(request.params.userId) : 0
    debugger    
    response.send('This is GET request')    
})
//POST can be tested by Postman
//api register user
router.post('/', 
    body('email').isEmail(),
    body('userName').isLength({
        min: 3
    }),
    body('password').isLength({
        min: 3
    }),
    body('address').isLength({
        min: 3
    }),
    async (request, response) => {        
    const errors = validationResult(request)    
    debugger
    if(!errors.isEmpty()) {
        return response.status(400).json({
            message: `Invalid input parametes`,
            errors: errors
        })        
    }
    const {userName = '',email='', password='', phone='', address=''} = request.body
    debugger    
    try {
        let createdUser = await User.create({userName, email, password, phone, address})
        return response.status(200).json({
            message: 'Register user successfully',
            data: createdUser
        })                
    }catch(exception) {
        return response.status(400).json({
            message: `Cannot register new user: ${exception}`
        })
    }
})
router.put('/', (request, response) => {
    //Example: api "update user information"
    response.send('This is PUT request from user router')    
})
router.delete('/', (request, response) => {
    //only soft-delete
    response.send('This is DELETE request from user router')    
})
module.exports = router