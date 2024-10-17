import React, { useState, useEffect } from 'react';
import axios from 'axios';
import {
  Form,
  useLoaderData,
  redirect,
  useNavigate,
} from "react-router-dom";

const apiUrl = import.meta.env.VITE_API_URL;

const NurseList = () => {
  const navigate = useNavigate();
  debugger
  const [nurses, setNurses] = useState([]);
  const [isLoading, setIsLoading] = useState(false);
  
  
  function handleDelete(nurseId) {
    console.log("Deleting nurse with ID:", nurseId);
    // Thêm logic xóa tại đây
  }
    
  function handleAddNew() {
    navigate('/add-new'); // Điều hướng đến màn hình Add New
  }

  function handleUpdate(nurseId) {
    navigate(`/update/${nurseId}`); // Điều hướng đến màn hình Update
  }

  
  useEffect(() => {
    // Gọi API GET để lấy dữ liệu Nurse
    setIsLoading(true)
    debugger

    axios.get(`${apiUrl}/Nurses`)
      .then(response => {
        setIsLoading(false)
        debugger
        setNurses(response.data); // Lưu dữ liệu nhận được vào state
      })
      .catch(error => {
        setIsLoading(false)
        console.error('There was an error fetching the nurses!', error);
      });
  }, []); // Chỉ chạy 1 lần khi component được render

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
              {nurses.map(nurse => (
                <tr key={nurse.nurseId}>
                  <td>{nurse.nurseId}</td>
                  <td>{nurse.name}</td>
                  <td>{nurse.certification}</td>
                  <td>{nurse.wardId}</td>
                  <td>
                    <button onClick={() => handleUpdate(nurse.nurseId)}>Update</button>
                    <button onClick={() => handleDelete(nurse.nurseId)}>Delete</button>
                  </td> {/* Cột chứa các nút Update và Delete */}
                </tr>
              ))}
            </tbody>
          </table>
          <button onClick={handleAddNew}>Add New</button> {/* Nút Add New bên dưới bảng */}
        </>
      ) : (
        <p>No data found</p>
      )}


    </div>
  );
}

export default NurseList;
