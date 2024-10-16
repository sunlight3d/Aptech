/**
 yarn add cors dotenv express express-validator mysql2

 npm install --save-dev nodemon
 */
const express = require('express');
require('dotenv').config();
const getConnection = require('./db/db')
const movieRoute = require('./routes/movieRoute')
const actorRoute = require('./routes/actorRoute')

//const bodyParser = require('body-parser');
const cors = require('cors')
const app = express();
app.use(express.json());
app.use(express.urlencoded({ extended: true}));
app.use(cors())

getConnection();

 const {
	SERVER_PORT,
    DB_HOST,
    DB_PORT,
    MYSQL_USER,
    MYSQL_PASSWORD,
} = process.env;
 //console.log(MYSQL_PASSWORD);
//app.use('/actors', actorRoute);
app.use('/api/movies', movieRoute);
app.use('/api/actors', actorRoute);
app.listen(SERVER_PORT, () => {
    console.log(`Server is running on port ${SERVER_PORT}`);
});

