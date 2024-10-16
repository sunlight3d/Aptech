import React from 'react'
import { Button, Stack, Form } from 'react-bootstrap'
import StudentList from './StudentList'
/**npm install react-bootstrap bootstrap
 
 */
function StudentManagement() {
    return <div className='container'>
        <h1>Student Management</h1>
        <Stack direction="horizontal">
            <Form.Label >Student name</Form.Label>
            <Form.Control type="text" placeholder="Enter your name" />
        </Stack>
        <Stack direction="horizontal">
            <Form.Label >Student DOB</Form.Label>
            <Form.Control type="text" placeholder="Enter your name" />
        </Stack>
        <StudentList />
    </div>
}
//make public
export default StudentManagement