const express = require('express')
const bodyParser = require('body-parser')
//import model for testing
const User = require('./models/user')

//Init app object from express function
const app = express()
app.use(express.urlencoded({extended: true}))
app.use(express.json())
const PORT = 3001
//import routers
const userRouter = require('./routers/user')
const productRouter = require('./routers/product')

//simple GET request
app.get('/', (request, response) => {
   response.send('Hello from Server') 
})
//config middleware routers
app.use('/users', userRouter)
app.use('/products', productRouter)
//test db connection
const dbConnection = require('./database/connection')

app.listen(PORT, () => {
    console.log(`Server is listening from port : ${PORT}`)
})
//1 entity => 1 route
