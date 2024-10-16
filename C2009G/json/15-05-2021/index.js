let x = 10 //number
let y = 20 //uu tien dung let nhieu hon var
//console.log("x = "+x+",y = "+y) //old, not good
console.log(`x = ${x}, y = ${y}`) //good

let x1 = "10" //string
let x3 = 10
if(x == x1) {
    //so sanh ve "gia tri"
    console.log('Bang nhau ve gia tri')
}
if(x === x3) {
    console.log('Bang nhau ca kieu va gia tri')
}
//kieu du lieu co cau truc, kieu object

let rectangle = {
    width: 200,
    height: 120,
    name: 'rect A',    
    getArea: function(){
        return this.width * this.height
    }    
}
let isEmpty = Object.keys(rectangle).length > 0
//them thuoc tinh khac 
rectangle.color = 'red'
console.log(`rectangle'width = ${rectangle.width}`)
//JSON = Javascript Object Notation
console.log(`rectangle = ${JSON.stringify(rectangle)}`)

let area = rectangle.getArea()
console.log(`area = ${area}`)
console.log(`x = ${!rectangle.x || rectangle.x.length == 0 ? 0 : rectangle.x}`) //filter du lieu
//ngan gon hon ?
//default value => ?? : null - coalescing

console.log(`x = ${rectangle.x ?? 0}`)
$(document).ready(function(){
    $('#pressMe').click(function(){
        let email = $('#email').val()?.trim()?.toLowerCase()
        let password = $('#password').val() //never trim
        console.log(`email = ${email}, password = ${password}`)        
    })
})
//khi can chuan hoa du lieu
//vi du chung ta co 1 form
//kieu du lieu array(array of object)
//js hoac jquery
//ta hay lam bang ReactJS

let questions = [
    {
        content: 'Một cộng 1 bằng mấy ?', 
        allAnswers :['Hai', 'sau', 2, 'ba', 'năm'],
        rightAnswers: [0, 2],
        selectedAnswers:[] 
        //isCorrect:
    },
    {
        content: 'What does HTML stand for??', 
        allAnswers :['Hyperlinks and Text Markup Language', ' Home Tool Markup Language', 'Hyper Text Markup Language'],
        rightAnswers: [2],
        selectedAnswers:[] 
        //isCorrect:
    },
    {
        content: 'Who is making the Web standards', 
        allAnswers :['Mozilla', 'The WWW consorsium', 'Google', 'Microsoft'],
        rightAnswers: [1],
        selectedAnswers:[] 
        //isCorrect:
    },
    {
        content: 'Choose the correct HTML element for the largest heading?', 
        allAnswers :['<heading>', '<h1>', '<h2>', 'h3', 'năm'],
        rightAnswers: [1],
        selectedAnswers:[] 
        //isCorrect:
    },
    {
        content: 'What is the correct HTML element for inserting a line break ?', 
        allAnswers :['<br>', '<lb>', 'breadk', 'ba', 'năm'],
        rightAnswers: [0],
        selectedAnswers:[] 
        //isCorrect:
    },
    {
        content: 'What is the correct HTML for adding a background color?', 
        allAnswers :['Hai', 'sau', 'yy', 'xx', ' &lt;body style="background-color:yellow;"&gt;'],
        rightAnswers: [4],
        selectedAnswers:[] 
        //isCorrect:
    },

]



