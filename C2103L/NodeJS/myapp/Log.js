const chalk = require('chalk');
const info = (message) => {
    console.log(message)
}
const error = (message) => {
    console.log(chalk.red(message));
}
const warn = (message) => {
    console.log(chalk.yellow(message));
}
module.exports = {
    info,
    error,
    warn
}