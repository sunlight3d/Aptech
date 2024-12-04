function doSomething() {
    let x = 4
    let y = 1;
    let fruits = ["orange", "lemon", "banana"]
    fruits.push("apple")
    fruits.push("grape")
    console.log(fruits[3])
    //hien ra xem mang fruits co bao nhieu phan tu ?
    console.log(`We have : ${fruits.length} items`)
    //iterate = i 
    for(let i = 0; i < fruits.length; i++) {
        console.log(`Phan tu thu ${i} la : ${fruits[i]}`)
    }

    //xoa phan tu(giong C):
    let fruits2 = []
    //xoa phan tu apple
    for(let i = 0; i < fruits.length; i++) {
        if(fruits[i] != 'apple') {
            fruits2.push(fruits[i])
        }
    }
    fruits = fruits2

    //xoa phan tu banana
    fruits = fruits.filter(item => item != "banana")
    //fruits = fruits.filter(item => item.studentId != "x1232255")
    //fruits.remove("banana") //not work
    debugger
    //alert(x+y)
    /*
    if(x > 5) {
        alert('x large than 5')
    } else if(x <= 5 && x >2 ){
        alert('x <= 5 and x > 2')
    } else {
        alert("x < = 2 day nhe")
    }
    */
}
doSomething() 

function validateForm() {
    const userId = document.getElementById("userId").value
    const password = document.getElementById("password").value
    const confirmPassword = document.getElementById("confirmPassword").value
    const email = document.getElementById("email").value
    const confirmEmail = document.getElementById("confirmEmail").value
    //validation
    if(userId.trim().length < 3) {
        alert("user'id must be at least 3 characters");
        return false
    }
    if(password != confirmPassword) {
        alert("Password and confirm password must be the same")
        return false
    }
    debugger    
    return true;
}
