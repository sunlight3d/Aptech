import { EventEmitter } from 'node:events'
import { userRepository } from '../repositories/index.js'

const myEvent = new EventEmitter()
myEvent.on('event-login', (params) => {
    //listen an event, listen anywhere
    console.log(`They talked about ... ${JSON.stringify(params)}`)
})
const login = async (req, res) => {
    //emitter something, emit a event
    //myEvent.emit('event-login', {x: 1, y: 2})    
    //destructuring
    const {email, password} = req.body
    let user = await userRepository.login(req.body)
    res.json({
        message: 'Login user succesfully',
        data: user
    })
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
    try {
        let user = await userRepository.register(req.body)
        res.json({
            //Output Response Format(for ReactJS, Angular,....)
            message: 'Register user succesfully',
            data: user
        })
    } catch(error) {
        res.json({
            //Output Response Format(for ReactJS, Angular,....)
            message: 'Register user failed',
            error
        })
    }
    //res.json({result: 'This is Register, POST'})
}
export default {
    login, register
}