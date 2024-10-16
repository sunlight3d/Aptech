const {
    sum2Numbers,
    multiply
} = require('./calculation.js')
const {
    print,
    LogLevel
} = require('./print.js')
print('Hello, this is an info', LogLevel.INFO);
print('This is errror', LogLevel.ERROR);
print('Warning, haha', LogLevel.WARNING);
print('This is successful', LogLevel.SUCCESS);
//console.log(`sum of 2 and 3 is : ${sum2Numbers(2,3)}`)
//console.log(`multiply of 2 and 3 is : ${multiply(2,3)}`)