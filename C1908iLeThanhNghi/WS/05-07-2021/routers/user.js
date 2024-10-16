const { response } = require('express')
const express = require('express')
const router = express.Router()

//config enpoints
//http://localhost:3001/users
router.get('/:userId', (request, response) => {
    const userId = request.params.userId != null ? parseInt(request.params.userId) : 0
    debugger    
    response.send('This is GET request')    
})
//POST can be tested by Postman
router.post('/', (request, response) => {
    debugger
    //Need dependency to read JSON params
    response.send('This is POST request from user router11')    
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