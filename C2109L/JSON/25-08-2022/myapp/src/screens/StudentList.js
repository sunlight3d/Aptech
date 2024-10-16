import {Table, Button} from 'react-bootstrap';
function StudentList(props) {
    // let students = props.students
    // let doSomething = props.doSomething
    //destructuring
    const {students, doSomething} = props
    //debugger
    return <div>
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
        doSomething()
    }}
    className="btn ms-2" 
    variant="outline-primary">Do Something</Button>  
    </div>
}
export default StudentList