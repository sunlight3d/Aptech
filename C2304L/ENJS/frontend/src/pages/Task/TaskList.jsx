import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Form,
  useLoaderData,
  redirect,
  useNavigate,
} from "react-router-dom";

const apiUrl = import.meta.env.VITE_API_URL;

const TaskList = () => {
  const navigate = useNavigate();

  const [tasks, setTasks] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  
  
  async function handleDelete(taskId) {
    console.log("Deleting task with ID:", taskId);
  
    // Hiển thị hộp thoại xác nhận trước khi xóa
    const confirmDelete = window.confirm("Are you sure you want to delete this task?");
  
    if (confirmDelete) {
      try {
        setIsLoading(true)
        // Gửi yêu cầu DELETE tới API
        const response = await axios.delete(`${apiUrl}/tasks/${taskId}`);
        console.log("Task deleted successfully:", response.data);        
        setTasks(tasks.filter(task => task.id !== taskId))        
        debugger
        setIsLoading(false)        
      } catch (error) {
        debugger
        setIsLoading(false)
        console.error("There was an error deleting the task:", error);        
      } 
    } else {
      console.log("Delete action was canceled.");
    }
  }
    
  function handleAddNew() {
    navigate('/add-new'); // Điều hướng đến màn hình Add New
  }

  function handleUpdate(taskId) {
    navigate(`/update/${taskId}`); // Điều hướng đến màn hình Update
  }

  
  useEffect(() => {
    async function getAllTasks() {
      setIsLoading(true)      
      axios.get(`${apiUrl}/tasks`)
      .then(response => {
        setIsLoading(false)        
        debugger
        setTasks(response?.data?.data ?? []); // Lưu dữ liệu nhận được vào state
      })
      .catch(error => {
        setIsLoading(false)
        console.error('There was an error fetching the tasks!', error);
      });
    }
    getAllTasks();
  }, [
    // tasks.length,    
  ]); // Chỉ chạy 1 lần khi component được render

  if (isLoading == true) {
    return <div>
      <h1>Data is loading</h1>
    </div>
  }
  return (
    <div>
      <h1>Danh sách các Task</h1>
      {tasks.length > 0 ? (
        <>
          <table>
            <thead>
              <tr>
                <th>Task ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Status</th>
                <th>Actions</th> {/* Thêm cột Actions */}
              </tr>
            </thead>
            <tbody>
              {tasks.map(task => {
                const {id, title, description, status} = task
                return (
                  <tr key={id}>
                    <td>{id}</td>
                    <td>{title}</td>
                    <td>{description}</td>
                    <td>{status}</td>
                    <td>
                      <button onClick={() => handleUpdate(id)}>Update</button>
                      <button onClick={() => handleDelete(id)}>Delete</button>
                    </td> {/* Cột chứa các nút Update và Delete */}
                  </tr>
                );
              })}
            </tbody>
          </table>          
        </>
      ) : (
        <p>No data found</p>
      )}
    <button onClick={handleAddNew}>Add New</button> {/* Nút Add New bên dưới bảng */}

    </div>
  );
}

export default TaskList;
