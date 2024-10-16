const { response } = require('express')
const express = require('express')
const router = express.Router()

//config enpoints
//more routers
//http://localhost:3001/products
router.get('/', (request, response) => {    
    debugger    
    //response.send('This is GET request, from Product router')    
    //When response HTML ?
    // response.writeHead(200, {'Content-Type': 'text/html'})
    // response.write("<h2 style='background-color:red'>this is GET List of Products</h2>")
    // response.end();
    //response json(Javascript Object Notation) 
    response.json({
        code:200,
        message: 'Query list of products successfully',
        products: []
    })
})
//database mongodb => nosql
//install mongodb on MacOS => on Docker
module.exports = router
//start mongo deamon:
//mongod --dbpath /Users/nguyenduchoang/Documents/mongoDb --port 27017
