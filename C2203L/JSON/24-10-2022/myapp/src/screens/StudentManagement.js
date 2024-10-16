import { useState, useEffect } from "react"

export function StudentManagement(props) {
    const [name, setName] = useState('')  
    const [dateOfBirth,setDateOfBirth] = useState('') 
    const [gender, setGender] = useState('Female')
    const [languages, setLanguages] = useState([
        {
            name: 'English',
            checked: true
        },
        {
            name: 'Japanese',
            checked: false
        },
        {
            name: 'German',
            checked: false
        },
        {
            name: 'French',
            checked: false
        },
        {
            name: 'Chinese',
            checked: false
        }
    ])
    return <center>
        <h1>Student Management</h1>
        <table>
            <tr>
                <td>Student name</td>
                <td>
                    <input type={'text'} 
                        value={name}
                        onChange={(event) => {
                            setName(event.target.value)
                        }}
                        placeholder={'Enter your name'}>
                    </input>
                </td>
            </tr>                                    
            <tr>
                <td>Student DOB</td>
                <td>
                    <input type={'date'} 
                        value={dateOfBirth}
                        onChange={(event) => {
                            setDateOfBirth(event.target.value)
                        }}
                        placeholder={'Enter your DOB'}>
                    </input>
                </td>
            </tr>                                    
            <tr>
                <td>Student Gender</td>
                <td>
                    <input type="radio" 
                        name="gender" 
                        onClick={(event) => {
                            debugger
                            setGender(event.target.value)
                        }}
                        value="Male" 
                        checked={gender=="Male"}/>Male
                    <input type="radio" 
                        onClick={(event) => {
                            debugger
                            setGender(event.target.value)
                        }}
                        name="gender" 
                        value="Female"
                        checked={gender=="Female"}/>Female
                </td>
            </tr>                                    
            <tr>
                <td>Languages:</td>
                <td>
                    {
                        languages.map(language => <span>
                            <input type="checkbox" 
                                name="gender" 
                                onClick={(event) => {
                                    //tao ra array moi clone tu array cu, sua isChecked
                                    setLanguages(languages.map(it => 
                                        it.name == language.name ?
                                        {
                                            ...it,
                                            checked: !it.checked
                                        }: it))                                          
                                }}
                                value={language.name}                     
                                checked={language.checked}/>{language.name}
                        </span>)
                    }
                    
                </td>
            </tr>                                    
        </table>
        <button onClick={()=>{

            debugger
        }}>Test</button>
    </center>
}