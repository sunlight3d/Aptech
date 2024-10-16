const {print, println} = require('./utilities')
let columns = 16;
let rows = 16;

let currentRowIndex = 0
let currentColumnIndex = 0
let outputIndexes = [
    //"0,4" => i = 0; j = 4
]
function moveRight(steps) {    
    for(let i = 0; i < steps; i++) {
        print(`(${currentRowIndex},${currentColumnIndex}) `)        
        outputIndexes.push(`${currentRowIndex},${currentColumnIndex}`)
        currentColumnIndex++
    }               
    println("")    
}
function moveDown(steps) {
    for(let i = 0; i < steps; i++) {
        print(`(${currentRowIndex},${currentColumnIndex}) `)
        outputIndexes.push(`${currentRowIndex},${currentColumnIndex}`)
        currentRowIndex++
    }        
    println("")    
}
function moveLeft(steps) { 
    for(let i = 0; i < steps; i++) {
        print(`(${currentRowIndex},${currentColumnIndex}) `)
        outputIndexes.push(`${currentRowIndex},${currentColumnIndex}`)
        currentColumnIndex--
    }              
    println("")    
}

function moveUp(steps) {
    for(let i = 0; i < steps; i++) {
        print(`(${currentRowIndex},${currentColumnIndex}) `)
        outputIndexes.push(`${currentRowIndex},${currentColumnIndex}`)
        currentRowIndex--
    }        
    println("")    
}

for(let i = 0; i < rows; i++) {
    for(let j = 0; j < columns; j++) {
        print(`(${i},${j}) `)
        if(j >= columns - 1) {
            println("")
        }        
    }    
}
println("test")
let currentColumns = columns - 1 
let currentRows = rows - 1
while(currentColumns > 0 && currentRows >0) {            
    moveRight(currentColumns)
    moveDown(currentRows)
    moveLeft(currentColumns)
    moveUp(currentRows)
    println("end round")       
    currentRowIndex++;
    currentColumnIndex++; 
    currentColumns = currentColumns - 2;
    currentRows = currentRows - 2;
    if(currentColumns < 0 || currentRows < 0) {
        print("haha")
        println(`${currentRows}, ${currentColumns}`)
    }
}
let dictionary = {
    //"0x2": 10 => i = 0, j = 2, value = 10
}
for(let index = 0; index < outputIndexes.length; index++) {
    let element = outputIndexes[index]
    let i = element.split(",").map(Number)[0]
    let j = element.split(",").map(Number)[1]
    dictionary[`${i}x${j}`] = index + 1;
}
println("output:")
for(let i = 0; i < rows; i++) {
    for(let j = 0; j < columns; j++) {        
        print((dictionary[`${i}x${j}`] ?? -1).toString()+",  ")                
        if(j >= columns - 1) {
            println("")
        }
    }    
}