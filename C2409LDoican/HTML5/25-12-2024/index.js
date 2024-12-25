let registerButton = document.getElementById('registerButton');
let users = [
    
]
function register(event) {
    debugger
    let fullname = document.getElementById('fullname').value;
    let username = document.getElementById('username').value;
    let email = document.getElementById('email').value;
    let phoneNumber = document.getElementById('phoneNumber').value;
    let password = document.getElementById('password').value;
    let confirmPassword = document.getElementById('confirmPassword').value;
    let gender = document.querySelector('input[name="rate"]:checked').value;
}
registerButton.addEventListener("click", register);