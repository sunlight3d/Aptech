import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Form,
  useLoaderData,
  redirect,
  useNavigate,
} from "react-router-dom";
import { flushSync } from 'react-dom';

const apiUrl = import.meta.env.VITE_API_URL;

const NurseList = () => {
  const navigate = useNavigate();

  const [nurses, setNurses] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  
  
  async function handleDelete(nurseId) {
    console.log("Deleting nurse with ID:", nurseId);
  
    // Hiển thị hộp thoại xác nhận trước khi xóa
    const confirmDelete = window.confirm("Are you sure you want to delete this nurse?");
  
    if (confirmDelete) {
      try {
        setIsLoading(true)
        // Gửi yêu cầu DELETE tới API
        const response = await axios.delete(`${apiUrl}/Nurses/${nurseId}`);
        console.log("Nurse deleted successfully:", response.data);        
        setNurses(nurses.filter(nurse => nurse.nurseId !== nurseId))
        //setNurses(prevNurses => prevNurses.filter(nurse => nurse.nurseId !== nurseId));
        debugger
        setIsLoading(false)
        // Thêm logic xử lý sau khi xóa thành công, ví dụ: cập nhật danh sách hiển thị
      } catch (error) {
        debugger
        setIsLoading(false)
        console.error("There was an error deleting the nurse:", error);
        // Xử lý lỗi, ví dụ: hiển thị thông báo lỗi cho người dùng
      } 
    } else {
      console.log("Delete action was canceled.");
    }
  }
    
  function handleAddNew() {
    navigate('/add-new'); // Điều hướng đến màn hình Add New
  }

  function handleUpdate(nurseId) {
    navigate(`/update/${nurseId}`); // Điều hướng đến màn hình Update
  }

  
  useEffect(() => {
    async function getAllNurses() {
      setIsLoading(true)
      debugger
      axios.get(`${apiUrl}/Nurses`)
      .then(response => {
        setIsLoading(false)        
        setNurses(response.data); // Lưu dữ liệu nhận được vào state
      })
      .catch(error => {
        setIsLoading(false)
        console.error('There was an error fetching the nurses!', error);
      });
    }
    getAllNurses();
  }, [
    // nurses.length,    
  ]); // Chỉ chạy 1 lần khi component được render

  if (isLoading == true) {
    return <div>
      <h1>Data is loading</h1>
    </div>
  }
  return (
    <div>
      <h1>Danh sách các Nurse</h1>
      {nurses.length > 0 ? (
        <>
          <table>
            <thead>
              <tr>
                <th>Nurse ID</th>
                <th>Tên</th>
                <th>Chứng nhận</th>
                <th>Ward ID</th>
                <th>Actions</th> {/* Thêm cột Actions */}
              </tr>
            </thead>
            <tbody>
              {nurses.map(nurse => {
                const {nurseId, name, certification, wardId} = nurse
                return (
                  <tr key={nurseId}>
                    <td>{nurseId}</td>
                    <td>{name}</td>
                    <td>{certification}</td>
                    <td>{wardId}</td>
                    <td>
                      <button onClick={() => handleUpdate(nurseId)}>Update</button>
                      <button onClick={() => handleDelete(nurseId)}>Delete</button>
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

export default NurseList;
