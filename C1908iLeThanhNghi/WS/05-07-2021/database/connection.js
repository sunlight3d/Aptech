const mongoose = require('mongoose')
const MONGO_SERVER = 'localhost'
const MONGO_PORT = 27017
const DB_NAME = 'test_db'
const URI = `mongodb://${MONGO_SERVER}:${MONGO_PORT}/${DB_NAME}`

//reconnect if failed !, after 3 seconds
var reconnectTimes = 0
const connectDatabase = () => {
    mongoose.connect(URI, {
        connectTimeoutMS: 3000,
    }).then(() => {
        console.log('connect mongo DB successfully')
    }).catch(error => {
        console.log(`cannot connect to MongoDB. Error: ${error}`)
        reconnectTimes = reconnectTimes + 1
        console.log(`connect DB again : ${reconnectTimes}`)
        setTimeout(connectDatabase, 3000)
    })
}
connectDatabase()
module.exports = mongoose