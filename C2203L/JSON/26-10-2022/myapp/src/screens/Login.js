import { useState, useEffect } from "react"

export function Login(props) {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [selectedFiles, setSelectedFiles] = useState([]);
    return <center>
        <h1>This is Login</h1>
        <table>
            <tr>
                <td>Username</td>
                <td>
                    <input type={'text'} 
                        value={username}
                        onChange={(event) => {
                            setUsername(event.target.value)
                        }}
                        placeholder={'Enter your username'}>
                    </input>
                </td>
            </tr>
            <tr>
                <td>Password</td>
                <td>
                    <input 
                        type={'password'} 
                        value={password}
                        onChange={(event) => {
                            setPassword(event.target.value)
                        }}
                        placeholder={'Enter password'} >
                    </input>
                </td>
            </tr>
            <tr>
                <td>Upload image</td>
                <td>
                    <input type={'file'} multiple
                        //value={selectedFiles.length > 0 ? selectedFiles[0] : null}
                        onChange={(event) => {
                            const newFiles = []                            
                            for(let eachFile of event.target.files) {
                                newFiles.push(eachFile)
                            }                                                        
                            if(event.target.files.length > 0) {
                                setSelectedFiles(selectedFiles.concat(newFiles))
                            }                            
                            //setSelectedFile(event.target.files[0])
                        }}
                    >
                    </input>
                </td>
            </tr>
            <tr>
                <td><button onClick={()=>{
                    debugger
                    alert(`username: ${username}, 
                        password: ${password}
                        images: ${JSON.stringify(selectedFiles)}
                        `)
                }}>Login</button></td>
                <td>
                    
                </td>
            </tr>
        </table>
    </center>
}