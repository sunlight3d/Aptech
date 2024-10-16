/*
npm install --save-dev jest 
 */
import express from 'express'
import * as dotenv from 'dotenv'
dotenv.config()//must have !
import {
  studentsRouter, 
  usersRouter    
} from './routes/index.js'
import connect from './database/database.js'
import { OutputType, print } from './helper/print.js'
import checkToken from './authentication/auth.js'

const app = express()

const port = 3002
app.use(express.json())
app.use(checkToken) //middleware, shield, guard,... 
// app.use(bodyParser.urlencoded({ extended: false }))
// app.use(bodyParser.json())
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
  await connect()
  print(`Example app listening on port ${port}`, OutputType.SUCCESS)  
})