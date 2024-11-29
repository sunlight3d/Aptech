//alert('chao cac ban')
console.log('helloo lhehei')
/*
function sum(a, b) {
    return a + b
}
*/
const sum = (a, b) => {
    return a + b
}
//console.log('sum of 1 and 4 is : '+sum(4,1))
const mrHoang = {
    name: 'Nguyen Duc Hoang',
    age: 18
}
/*
mrHoang = {
    name: 'Nguyen Duc Hoang',
    age: 18
}
*/
mrHoang.age = 30
x = 4
y = 5

const mrX = mrHoang
mrHoang.age = 40
mrHoang.name = 'hahaaha'
const mrY = {}
mrY.name = mrHoang.name
mrY.age = mrHoang.age
mrHoang.age = 19

console.log(`age of mrX is = ${mrX.age}`)
console.log(`name of mrX is = ${mrX.name}`)
console.log(`age of mrY is = ${mrY.age}`)

mrZ = {...mrHoang} // spread operator
mrHoang.age = 16


//mrX.age = ????

console.log(`sum of ${x} and ${y} is : ${sum(x,y)}`) //string concatenation
console.log(mrHoang)

console.log(mrZ)


