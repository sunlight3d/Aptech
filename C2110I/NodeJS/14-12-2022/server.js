import express from 'express'
import bodyParser from 'body-parser'
import {
  studentsRouter, 
  usersRouter    
} from './routes/index.js'


const app = express()
const port = 3002
app.use(bodyParser.urlencoded({ extended: false }))
app.use(bodyParser.json())
/**
 mongodb: MongoServer | MongodB+Docker | MongoCloud
 mongo client: Mongo shell, Mongo compass, Robo3T
 
 */
//routes

app.use('/students', studentsRouter)
app.use('/users', usersRouter)

app.get('/', async (req, res) => {
    console.log(req.params)
    res.send('Root router, test only')
})

app.listen(port, async () => {
  console.log(`Example app listening on port ${port}`)
})