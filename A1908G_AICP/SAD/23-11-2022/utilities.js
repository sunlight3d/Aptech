function print(inputString) {
    process.stdout.write(inputString)
}
function println(inputString) {
    print(inputString)
    console.log()
}
module.exports = {
    print, println
}