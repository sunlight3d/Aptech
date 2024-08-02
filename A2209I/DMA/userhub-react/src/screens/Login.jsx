import { useState } from "react"

function Login(){
    const [email, setEmail] = useState('');//react hook
    const [password, setPassword] = useState('');
    return <div>
        <h1>Login to your account</h1>
        <div>
            <input type="text" placeholder="Enter your email"
             onChange={(event) => setEmail(event.target.value)}/>
        </div>
        <div>
            <input type="password" placeholder="Enter your password" 
                onChange={(event) => setPassword(event.target.value)}/>
        </div>
        <button onClick={(event) => {
            alert(`Email = ${email}, password = ${password}`)
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