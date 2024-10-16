const { EventEmitter } = require('node:events')
const myEvent = new EventEmitter()
myEvent.on('event-login', (params) => {
    //listen an event, listen anywhere
    console.log(`They talked about ... ${JSON.stringify(params)}`)
})
const login = (req, res) => {
    //emitter something, emit a event
    //myEvent.emit('event-login', {x: 1, y: 2})    
    //destructuring
    const {email, password} = req.body
    res.json({
        result: 'This is Login haha, POST',        
        input: `Email = ${email}, password = ${password}`
    })
}
const register = (req, res) => {
    res.json({result: 'This is Register, POST'})
}
module.exports = {
    login, register
}