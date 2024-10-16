import { EventEmitter } from 'node:events'
import { userRepository } from '../repositories/index.js'
import { ObjectId, Schema } from "mongoose"

const myEvent = new EventEmitter()
myEvent.on('event-login', (params) => {
    //listen an event, listen anywhere
    console.log(`They talked about ... ${JSON.stringify(params)}`)
})
/**

curl -X POST http://localhost:3002/users/login \
   -H 'Content-Type: application/json' \
   -d '{"email":"nguyenvana123@gmail.com","password":"123456"}'

*/
const login = async (req, res) => {
    //emitter something, emit a event
    //myEvent.emit('event-login', {x: 1, y: 2})    
    //destructuring
    try {
        const {email, password} = req.body
        let user = await userRepository.login(req.body)
        res.json({
            message: 'Login user succesfully',
            data: user
        })
    }catch(exception) {
        res.json({
            message: exception.message            
        })
    }
}
const register = async (req, res) => {
    //validate req.body ? need a "Data Transfer Object"
    // {
    //     name, 
    //     email, 
    //     password, 
    //     phoneNumber,
    //     address
    // }
    debugger
    let user = await userRepository.register(req.body)
    res.json({
        //Output Response Format
        message: 'Register user succesfully',
        data: user
    })
    //res.json({result: 'This is Register, POST'})
}
const getDetailUser = async (req, res) => {
    let token = req.headers.authorization?.split(" ")[1]
    let decodedObject = jwt.verify(token, process.env.JWT_SECRET);
    let userId = decodedObject.data._id
    debugger
    try {
        let user = await User.findById(userId).exec()
        res.json({
            //Output Response Format
            message: 'Get detail user succesfully',
            data: user
        })        
    }catch(error) {
        debugger
        res.json({
            //Output Response Format
            message: 'Get detail user failed',
            data: user
        })        
    }        
}

export default {
    login, 
    register,
    getDetailUser
}