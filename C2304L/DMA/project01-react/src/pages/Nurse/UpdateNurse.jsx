import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import axios from 'axios';
const apiUrl = import.meta.env.VITE_API_URL;

export default function UpdateNurse() {
  const { nurseId } = useParams();
  
  const [nurse, setNurse] = useState({
    name: '',
    certification: '',
    wardId: ''
  });
  const navigate = useNavigate();

  useEffect(() => {
    const fetchNurse = async () => {
      try {
        console.log(`Fetching nurse with ID: ${nurseId}`);
        const response = await axios.get(`${apiUrl}/Nurses/${nurseId}`);
        debugger
        setNurse(response.data);
      } catch (error) {
        debugger
        console.error('Error fetching nurse data:', error);
      }
    };

    fetchNurse();
  }, [nurseId, apiUrl]); // Chỉ gọi API khi nurseId hoặc apiUrl thay đổi

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {      
      debugger
      // Gửi yêu cầu PUT để cập nhật thông tin nurse
      await axios.put(`${apiUrl}/Nurses/${nurseId}`, nurse, {
        headers: {
          'Content-Type': 'application/json',
          'Accept': '*/*'
        }
      });

      console.log("Nurse updated successfully!");
      // Điều hướng về trang chính hoặc trang nào đó sau khi cập nhật thành công
      navigate('/');
    } catch (error) {
      console.error("There was an error updating the nurse!", error);
    }
  };

  return (
    <div>
      <h2>Update Nurse</h2>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Tên:</label>
          <input
            type="text"
            value={nurse.name}
            onChange={(e) => setNurse({ ...nurse, name: e.target.value })}
            required
          />
        </div>
        <div>
          <label>Chứng nhận:</label>
          <input
            type="text"
            value={nurse.certification}
            onChange={(e) => setNurse({ ...nurse, certification: e.target.value })}
            required
          />
        </div>
        <div>
          <label>Ward ID:</label>
          <input
            type="text"
            value={nurse.wardId}
            onChange={(e) => setNurse({ ...nurse, wardId: e.target.value })}
            required
          />
        </div>
        <button type="submit">Update Nurse</button>
      </form>
    </div>
  );
}
