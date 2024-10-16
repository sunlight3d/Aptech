import { useState, useEffect } from 'react';
import { fetchStudents } from '../api/studentApi';
import { Link } from 'react-router-dom';

function StudentList(props) {
    const [students, setStudents] = useState([]);        
    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await fetchStudents();                
                setStudents(data);
            } catch (error) {
                console.error('Error fetching students:', error);
            }
        };

        fetchData();
    }, []);
    const handleDelete = async (id) => {
        // Implement delete logic here
        console.log(`Delete student with ID: ${id}`);
    };
    return (
        <>
            <h1>This is Student list</h1>            
            
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Email</th>
                        <th>Phone</th>
                        <th>Actions</th> 
                    </tr>
                </thead>
                <tbody>
                {students.map((student, index) => (
                    <tr key={student.id || index}>
                        <td>{student.name}</td>
                        <td>{student.age}</td>
                        <td>{student.email}</td>
                        <td>{student.phone}</td>
                        <td>
                            <button onClick={() => handleDelete(student.id)}>Delete</button>
                            <Link to={`/update/${student._id}`}>
                                <button>Update</button>
                            </Link>
                        </td>
                    </tr>
                ))}
                </tbody>
            </table>
            <Link to="/add-new">
                <button>Add New</button>
            </Link>
        </>
    );
}

export default StudentList;
