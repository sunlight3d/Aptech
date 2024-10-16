console.log('Hello')
const HOST = '192.168.1.2'

let x = 1
let y = 20
var a = 100
for(let i = 0; i < 10; i++){
    let a = 200;
    console.log(`a trong block = ${a}`)
    
}
console.log(`a ngoai block = ${a}`)
//const tham chieu den 1 ham
const tong2So = function(x, y) {
    return x + y
}
//arrow function
const multiply = (x, y) => {
    return x * y
}

console.log(`Tong cua 2 va 3 la : ${tong2So(2,3)}`)
console.log(`Multiply 2 and 3 is : ${multiply(2,3)}`)
//one-line function
const substract2Numbers = (x, y) => x - y
//ternary expression 
const isRich = (moneyAmount) => (moneyAmount > 1000000) ? 
                                    'Rich' :'Not rich'
console.log(`Result = ${isRich(100000)}`)
//json = Javascript Object Notation
//json, dictionary, hashtable, 
//define an object
let personA = {
    name: 'Hoang',
    age: 18,
    email: 'hoang@gmail.com',
    run: function(){
        console.log('I am running')
    },
    'ten nguoi': 'haha'
}
personA['ten nguoi'] //ok
//personA['name'] hoac personA.name deu duoc
//let personB = personA //reference
//let personB = {...personA} //clone = assign, nen dung 
//let personB = Object.assign({}, personA)//it dung, dung cho js cu
let personB = JSON.parse(JSON.stringify(personA))//ko nen dung 
personA.name = 'haha'
console.log(`name = ${personB.name}`)  

let xx = 10 //primitive value
let yy = xx //clone = assign
xx = 11
console.log(`yy = ${yy}`)
let coors = [
    {x: 1, y: 2},
    {x: 3, y: 4},
    {x: 4, y: 12},
    //...
]
let toado = {
    1: 2,
    3: 4,
    4: 12,    
}
console.log(`voi x = 3 thi y = ${toado[3]}`)





