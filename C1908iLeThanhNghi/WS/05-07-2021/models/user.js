const mongoose = require('mongoose')
const UserSchema = new mongoose.Schema({
    userName: String,
    email: {
        type: String,
        required: true
    },
    password: {
        type: String,
        required: true
    },
    phone: String,
    address: String,    
    isAtive: Boolean
})
//product model ?
module.exports = mongoose.model('User', UserSchema)