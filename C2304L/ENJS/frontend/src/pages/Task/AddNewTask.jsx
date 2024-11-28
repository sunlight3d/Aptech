import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

const apiUrl = import.meta.env.VITE_API_URL;

export default function AddNewTask() {
  const [task, setTask] = useState({
    title: '',
    description: '',
    status: ''
  });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      debugger  
      const response = await axios.post(`${apiUrl}/tasks`, task);
      debugger
      console.log('Task added:', response.data);
      navigate('/'); // Navigate back to task list after adding
    } catch (error) {
      debugger  
      console.error('Error adding task:', error);
    }
  };  

  return (
    <div>
      <h2>Add New Task</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Title:</label>
          <input
            type="text"
            value={task.title}
            onChange={(e) => setTask({ ...task, title: e.target.value })}
            required
          />
        </div>
        <div>
          <label>Description:</label>
          <input
            type="text"
            value={task.description}
            onChange={(e) => setTask({ ...task, description: e.target.value })}
            required
          />
        </div>
        <div>
          <label>Status:</label>
          <select
            value={task.status}
            onChange={(e) => setTask({ ...task, status: e.target.value })}
            required
          >
            <option value="Pending">Pending</option>
            <option value="In Progress">In Progress</option>
            <option value="Completed">Completed</option>
          </select>
        </div>

        <button type="submit">Add Task</button>
      </form>
    </div>
  );
}
