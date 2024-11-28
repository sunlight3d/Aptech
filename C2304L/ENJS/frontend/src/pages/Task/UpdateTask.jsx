import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
const apiUrl = import.meta.env.VITE_API_URL;

export default function UpdateTask() {
  const { taskId } = useParams();
  
  const [task, setTask] = useState({
    title: '',
    description: '',
    status: ''
  });
  const navigate = useNavigate();

  useEffect(() => {
    const fetchTask = async () => {
      try {
        console.log(`Fetching task with ID: ${taskId}`);
        const response = await axios.get(`${apiUrl}/tasks/${taskId}`);
        //get existing task from id
        debugger
        setTask(response.data?.data);
      } catch (error) {
        debugger
        console.error('Error fetching task data:', error);
      }
    };

    fetchTask();
  }, [taskId, apiUrl]); // Chỉ gọi API khi taskId hoặc apiUrl thay đổi

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {      
      debugger
      // Gửi yêu cầu PUT để cập nhật thông tin task
      await axios.put(`${apiUrl}/tasks/${taskId}`, task, {
        headers: {
          'Content-Type': 'application/json',
          'Accept': '*/*'
        }
      });

      console.log("Task updated successfully!");
      // Điều hướng về trang chính hoặc trang nào đó sau khi cập nhật thành công
      navigate('/');
    } catch (error) {
      console.error("There was an error updating the task!", error);
    }
  };

  return (
    <div>
      <h2>Update Task</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Tên:</label>
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
        <button type="submit">Update Task</button>
      </form>
    </div>
  );
}
