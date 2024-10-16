console.log('haha')
//alert('chao cac ban')
const x = 10 //const => let => var
const y = 20
//debugger
//string concatenation
console.log(`x = ${x}, y = ${y}`)
let name = 'Hoang'
let email = 'oangdsj@gmail.com'
const info = name+', '+email
console.log(info)
let z = x * x + 233
//alert(`z = ${z}`)
for(let i = 0; i < 10; i++){
    console.log('i = '+i)
}
let fruits = ['orange', 'apple', 'lemon', 'avocado']
let numberOfPersons = 10
/*
for(let i = 0; i < fruits.length; i++){
    let fruit = fruits[i]
    console.log(fruit)
}
*/
console.log('iterate a list using foreach')
fruits.forEach((fruit) => {
    //arrow/anonymous function,
    console.log(fruit)
});
//object in js
let studentA = {
    name: 'Nguyen Van A',
    year: 1998,
    email: 'njh@gmail.com'
}
let studentB = studentA //reference,not assignment
//assign or clone
let studentC = {...studentA} 
studentA.name = 'haha'

//debugger
//array/list of objects
let students = [
    {
        name: 'Hoang',
        age: 18
    },
    {
        name: 'John',
        age: 22
    },
    {
        name: 'Henry',
        age: 32
    },
    {
        name: 'Elon',
        age: 44
    }
]
//JSON = javascript Object Notation
//console.log(`studentA\' detail: ${JSON.stringify(studentA)}`)
console.log(JSON.stringify(students))
//iterate an array of objects
students.forEach(student => {
    console.log(`name = ${student.name}, age = ${student.age}`)
})

//filter an array(traditional way)
let filteredStudents = []
// students.forEach(student => {
//     if(student.age < 30) {
//         filteredStudents.push(student)
//     }
// })
//better way
filteredStudents = students.filter(student => 
                student.age < 30)
//? = optional
filteredStudents = students.filter(student => 
            student.fullName?.toLowerCase()?.includes('h'))
console.log(JSON.stringify(filteredStudents))
//console.log(JSON.stringify(students))
students = students.filter(student => 
                student.name?.toUpperCase() != 'Henry'.toUpperCase())
console.log(JSON.stringify(students))
//update 
const persons = [
    {
        name:'aa',
        age: 11
    },
    {
        name:'bb',
        age: 22
    }
]
//persons = []
persons[0].name = 'yyyy'//ok, why ?
//freeze = immutable object => cannot change item's value

console.log(JSON.stringify(persons))








