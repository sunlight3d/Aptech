var colors = require('colors')
const LogLevel = Object.freeze({
    INFO: 'info',
    WARNING: 'warning',
    ERROR: 'error',
    SUCCESS: 'success'
});
const print = (message, logLevel) => {
    if(logLevel == LogLevel.INFO) {
        console.log(message.white)
    } else if(logLevel == LogLevel.WARNING) {
        console.log(message.yellow)
    } else if(logLevel == LogLevel.ERROR) {
        console.log(message.red)
    } else if(logLevel == LogLevel.SUCCESS) {
        console.log(message.green)
    }
}
module.exports = {
    LogLevel,    
    print
}  