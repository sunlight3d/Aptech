
function login() {
    debugger
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;
    if(username== 'admin' && password == '123456') {
        alert('Login success !. Redirect to next page');
    } else {
        alert('Login failed !. Incorrect username or password');
    }
}

