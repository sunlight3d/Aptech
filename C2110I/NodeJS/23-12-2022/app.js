//npm = Node Package Manager
//nodemon = node monitor

//const sum = require("./calculation").sum //not Good !
//const PI = require("./calculation").PI //not Good !
//distructuring is better
const fs = require('fs')
const os = require('os')
const {
    sum, 
    PI, 
    multiply, 
    substract
} = require("./calculation") //why const ? ref to a function is "const"
const {
    getAllStudents,
    insertStudent,
    deleteStudent
} = require('./repositories/studentRepository')

console.log("Chao cac ban haha")
console.log('3 plus 2 = '+sum(3, 2))
console.log('PI = '+PI)
console.log(`multiply 3 and 5 is: ${multiply(3, 5)}`)
//built-in modules
console.log(__dirname) //Global variable
console.log(os.userInfo())

insertStudent({
    id: "xx1122",
    klass: 'xc122',
    name: 'n1',
    age: 30,    
    gender: 'male',
    phoneNumber: '112233', 
    address: 'aa1111',    
    languages: ['Chinese'],
})
deleteStudent('efexa')
deleteStudent('ffexf')
console.log(getAllStudents())


