import { useState, useEffect } from "react"
import './studentManagement.css'
export function StudentManagement(props) {
    const [name, setName] = useState('')  
    const [dateOfBirth,setDateOfBirth] = useState('') 
    const [gender, setGender] = useState('Female')
    const [klasses, setKlasses] = useState([
        {
            name: 'C2203L',
            selected: true
        },
        {
            name: 'A2010G',
            selected: false
        },
        {
            name: 'C1908G1',
            selected: false
        }
    ])
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
    const [students, setStudents] = useState([])
    return <center>
        <h1>Student Management</h1>
        <table className="table2">
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
            <tr>
                <td>Student class:</td>
                <td>                    
                    <select onChange={(event) => {
                        setKlasses(klasses.map(klass => {
                            return {
                                ...klass,
                                selected: klass.name == event.target.value
                            }
                        }))
                    }}>
                        {klasses.map(klass => 
                            <option value={klass.name} selected={klass.selected}>
                                {klass.name}
                            </option>)}                                                                        
                    </select>
                </td>
                <td><button onClick={(event) => {
                    const klassName = prompt("Enter your new class's name", "");
                    if(klassName == null || klassName.trim().length == 0) {
                        return
                    }
                    const isDublicate = klasses.find(klass =>
                        klass.name.toLocaleLowerCase().trim()
                        == klassName.toLocaleLowerCase().trim())
                    if (!isDublicate) {
                        setKlasses(klasses.concat({
                            name: klassName,
                            selected: false
                        }))
                    }
                }}>Add Class</button></td>
            </tr>                                    
        </table>
        <button onClick={(event) => {
            //CUUih9XJufRnt1ziHFarmn7DCJWcpJVU
            const selectedClass = klasses
                    .find(klass => klass.selected == true)            
            const selectedLanguages = languages
                    .filter(language => language.checked == true)
            //alert(`${JSON.stringify(selectedClass)}, ${JSON.stringify(selectedLanguages)}`)            
            setStudents(students.concat({
                name,
                klass: selectedClass.name,
                dob: dateOfBirth,
                gender,
                language: selectedLanguages.map(item => item.name)?.join(",")
            }))
        }}>Add</button>        
        <table>
            <tr>
                <th>Name</th>
                <th>Class</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Language</th>
                <th></th>
            </tr>
            {
                students.map(student => <tr>
                    <td>{student.name}</td>
                    <td>{student.klass}</td>
                    <td>{student.dob}</td>
                    <td>{student.gender}</td>
                    <td>{student.language}</td>
                    <td></td>
                </tr>)
            }
        </table>
    </center>
}