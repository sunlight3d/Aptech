const express = require('express')
const bodyParser = require('body-parser')

const app = express()
const port = 3002
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())

//routes
const {
    studentsRouter, 
    usersRouter    
} = require('./routes')

app.use('/students', studentsRouter)
app.use('/users', usersRouter)

app.get('/', (req, res) => {
    console.log(req.params)
    res.send('Root router, test only')
})


app.listen(port, () => {
  console.log(`Example app listening on port ${port}`)
})