import axios from 'axios';

export const fetchStudents = async () => {
    const url = `${import.meta.env.VITE_APP_API_BASE_URL}/students`;
    const response = await axios.get(url);
    
    if (response.status !== 200) {
        throw new Error('Failed to fetch students');
    }
    return response.data;
};

export const insertStudent = async ({ name, age, email, phone }) => {
    const url = `${import.meta.env.VITE_APP_API_BASE_URL}/students`;    
    try {
        debugger
        const response = await axios.post(url, {
            name,
            age,
            email,
            phone,
            // Add other fields as needed
        });

        if (response.status != 200 || response.status != 201) {
            throw new Error('Failed to insert student');
        }

        return response.data;
    } catch (error) {
        debugger
        console.error('Error inserting student:', error);
        throw error; // Re-throw the error to handle it in the component
    }
};
export const getStudentById = async (id) => {
    debugger
    const url = `${import.meta.env.VITE_APP_API_BASE_URL}/students/${id}`;
    const response = await axios.get(url);
    debugger
    
    if (response.status !== 200) {
        throw new Error('Failed to fetch student');
    }
    return response.data;
};
