import { useState } from "react"
import axios from "axios";
function Login(){
    const [email, setEmail] = useState('hoang12@gmail.com');//react hook
    const [password, setPassword] = useState('123456');
    return <div>
        <h1>Login to your account</h1>
        <div>
            <input type="text" placeholder="Enter your email"
            value={email}
             onChange={(event) => setEmail(event.target.value)}/>
        </div>
        <div>
            <input type="password" placeholder="Enter your password" 
                value={password}
                onChange={(event) => setPassword(event.target.value)}/>
        </div>
        <button onClick={(event) => {
            //alert(`Email = ${email}, password = ${password}`)
            axios.post('https://localhost:7169/api/Auth/login', {
                email: email,
                password: password
              })
              .then(function (response) {
                const jwtToken = response?.data ?? '';
                localStorage.setItem('token', jwtToken)
                debugger
                //get user's detail from token
                const headers =  {
                    'authorization': `Bearer ${jwtToken}`,
                    'Accept' : 'application/json',
                    'Content-Type': 'application/json'
                }
                axios.post('https://localhost:7169/api/Auth/me', {
     
                  }, {headers})
                  .then(function (response) {
                    localStorage.setItem('user_id', response?.data.id)
                    debugger
                  })
                  .catch(function (error) {
                    debugger
                    console.log(error);
                  });
              })
              .catch(function (error) {
                debugger
                console.log(error);
              });
            console.log('haha');  
        }}>Login to your account</button>
    </div>
}
export default Login
/*
const Login = (props) => {
    return <h1>Loginnnnnnnn</h1>
}
    
export default Login;
*/
/*
function Login(){
    return <h1>This is Login</h1>
}
export default Login
*/