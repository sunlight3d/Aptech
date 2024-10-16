const mongoose = require('../database/connection')
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
UserSchema.index({ email: 1 }, { unique: true })
//product model ?
module.exports = mongoose.model('User', UserSchema)
