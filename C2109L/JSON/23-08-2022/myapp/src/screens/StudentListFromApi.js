import { useEffect, useState } from 'react'
import {Table, Button} from 'react-bootstrap'
const axios = require('axios').default;
function StudentListFromApi(props) {
    // let students = props.students
    // let doSomething = props.doSomething
    //destructuring
    const [students, setStudents] = useState([])
    useEffect(() => {
        //debugger
        let mounted = true
        axios.get('http://localhost:8086/products.php')
        .then(function (response) {            
            debugger
            console.log(response);
            if(mounted) {
                setStudents(response?.data?.students ?? [])
            }            
          })
          .catch(function (error) {
            debugger            
            console.log(error);
          })         
          return () => mounted = false; 
    }, [])
    //debugger
    return <div>
        <h1>This demo get students object from API</h1>
        <Table striped bordered hover>
            <thead>
                <tr>
                <th>Name</th>
                <th>Class</th>
                <th>DOB</th>
                <th>Gender</th>
                <th>Language</th>
                <th></th>
                </tr>
            </thead>
            <tbody>
                {
                    students.map(eachStudent => {
                        //debugger
                        return <tr key={eachStudent.name}>
                            <td>{eachStudent.name}</td>
                            <td>{eachStudent.class}</td>
                            <td>{eachStudent.DOB}</td>
                            <td>{eachStudent.gender}</td>
                            <td>{eachStudent.languages}</td>
                            <td></td>
                        </tr>
                    })
                }
                               
        </tbody>
    </Table>
    <Button 
    onClick={()=>{
        debugger        
    }}
    className="btn ms-2" 
    variant="outline-primary">Do Something</Button>  
    </div>
}
export default StudentListFromApi