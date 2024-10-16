$(document).ready(function(){
    //all tags has been loaded   
    //debugger    
    let x = 10    
    let y = 20
    x = x * 100
    //let message = "Value of x = "+x //string concatenation
    let message2 = `Value of x = ${x}, y = ${y}` //string template
    console.log(message2)
    let someNumbers = [2, 4, 5, 6, 7,9]
    // for(let i = 0; i < someNumbers.length; i++) {
    //     let eachNumber = someNumbers[i]
        
    // }
    for(let eachNumber of someNumbers) {
        //debugger
    }
    /*
    function sum2Numbers(x, y) {
        return x + y
    }
    */
   const sum2Numbers = (x, y) => x + y

   console.log(sum2Numbers(2, 3))
})