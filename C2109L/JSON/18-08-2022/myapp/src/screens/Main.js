import StudentList from "./StudentList"
import {InputGroup,Form, Col, 
    Button,
    Row, Dropdown} from 'react-bootstrap';
import DatePicker from "react-datepicker";
import "react-datepicker/dist/react-datepicker.css"
import { useState, useEffect } from "react";

function Main() {
    const [student, setStudent] = useState({}) //state is immutable
    
    const [students, setStudents] = useState([
        {
            name: 'Nguyen Van A',
            class: "C2019L",
            DOB: '1970-12-25',
            gender:'male',
            language: ['English', 'German']
        },
        {
            name: 'Ngdmdikjfen Van A',
            class: "C2233L",
            DOB: '2000-12-25',
            gender:'Female',
            language: ['English', 'Russia']
        }
    ])
    useEffect(() => {
        debugger
    })
    return <div className="container">
        <h1>Input student information</h1>
        <Row className="mb-3">
            <Form.Label column sm="2">
            Student Name
            </Form.Label>
            <Col sm="10">
                <Form.Control 
                    onChange={(event) => {
                        debugger
                        //student.name = event.target.value //NO!
                        setStudent({
                            ...student, //spread operator
                            name: event.target.value
                        })
                    }}
                    placeholder="Enter your name" />
            </Col>
        </Row>        
        <Row className="mb-3">
            <Form.Label column sm="2">
            Date of Birth
            </Form.Label>
            <Col sm="10">
                <DatePicker
                        placeholderText="Enter your DOB"
                        onSelect={() => {

                        }} //when day is clicked
                        onChange={() => {
                            debugger
                        }} //only when value has changed
                    />
            </Col>
        </Row>
        <Row className="mb-3">
            <Form.Label column sm="2">
                Gender
            </Form.Label>
            <Col sm="10">
                <Row>
                    <Form.Check 
                        className="ms-2"
                        type={'radio'}
                        id={`default-radio`}
                        name ={"gender"}
                        label={"Male"} />
                    <Form.Check 
                        className="ms-2"
                        type={'radio'}
                        name ={"gender"}
                        id={`default-radio`}
                        label={`Female`} />
                </Row>                
            </Col>
        </Row>
        <Row className="mb-3">
            <Form.Label column sm="2">
                Language
            </Form.Label>
            <Col sm="10">                
                <InputGroup>
                    <Form.Check 
                        className="ms-2"
                        type={'checkbox'}
                        id={`default-radio`}
                        name ={"language"}
                        label={"English"} />                    
                    
                    <Form.Check 
                        className="ms-2"
                        type={'checkbox'}
                        id={`default-radio`}
                        name ={"language"}
                        label={"Vietnamese"} />                    
                </InputGroup>                             
            </Col>
        </Row>
        <Row className="mb-3">
            <Form.Label column sm="2">
                Student Class
            </Form.Label>
            <Col sm="5">                
            <Row>
                    <Col>
                        <Dropdown>
                            <Dropdown.Toggle variant="success" id="dropdown-basic">
                                Dropdown Button
                            </Dropdown.Toggle>

                            <Dropdown.Menu>
                                <Dropdown.Item href="#/action-1">Action</Dropdown.Item>
                                <Dropdown.Item href="#/action-2">Another action</Dropdown.Item>
                                <Dropdown.Item href="#/action-3">Something else</Dropdown.Item>
                            </Dropdown.Menu>
                        </Dropdown>
                    </Col>
                <Col>
                    <Button className="btn ms-2" variant="outline-primary">Add class</Button>                    
                </Col>
            </Row>                                
            </Col>
        </Row>
        <Button 
            onClick={()=>{
                debugger                
            }}
            className="btn ms-2" 
            variant="outline-primary">Insert Student</Button>  
        <StudentList students={students} doSomething = {() => {
            debugger
        }}/>
    </div>
}
export default Main