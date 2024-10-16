const chalk = require('chalk')
const fs = require('fs');
const path = require('path');
const LOG_FILE_PATH = path.join(__dirname, 'log.txt')
const LOG_TYPE = {
    ERROR : 'error',
    WARNING: 'warning',
    INFO: 'info',
}

function print(message, logType) {
    let outMessage = `${new Date()} - ${message}` 
    if(logType == LOG_TYPE.ERROR) {
        chalk.red(outMessage)
    } else if(logType == LOG_TYPE.WARNING) {
        chalk.yellow(outMessage)
    } else if(logType == LOG_TYPE.INFO) { 
        console.log(outMessage)    
    }    
    saveLog(outMessage, ()=>{})    
}
//DRY - Donot repeat yourself
function saveLog(message, finished) {
    fs.appendFile(LOG_FILE_PATH, "\n" + message, (err) => {
        if (err) throw err;
        finished()        
    });
}
module.exports = {
    print,
    LOG_TYPE
}