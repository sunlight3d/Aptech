let registerButton = document.getElementById('registerButton');
let users = [
    
]
function checkEmail(email) {
    return email.match(/^[a-zA-Z0-9]+@[A-Za-z]+\.[a-zA-Z]{3}/g) ?.length > 0;
}
function register(event) {
    debugger
    let fullname = document.getElementById('fullname').value;
    let username = document.getElementById('username').value;
    let email = document.getElementById('email').value;
    let phoneNumber = document.getElementById('phoneNumber').value;
    let password = document.getElementById('password').value;
    let confirmPassword = document.getElementById('confirmPassword').value;
    let gender = document.querySelector('input[name="gender"]:checked')?.value;
    
    if(!checkEmail(email)) {
        alert('Email must be in correct format')
        return;
    }
    //validate
    if(password !== confirmPassword) {
        alert('Password and confirm password must be the same')
        return;
    }

    users.push({
        fullname,
        username,
        email,
        phoneNumber,
        password,
        gender
    })
    alert(JSON.stringify(users))
}
registerButton.addEventListener("click", register);