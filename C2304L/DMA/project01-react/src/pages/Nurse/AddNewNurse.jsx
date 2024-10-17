import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

export default function AddNewNurse() {
  const [nurse, setNurse] = useState({
    name: '',
    certification: '',
    wardId: ''
  });
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      debugger  
      const response = await axios.post(`${import.meta.env.VITE_API_URL}/Nurses`, nurse);
      debugger
      console.log('Nurse added:', response.data);
      navigate('/'); // Navigate back to nurse list after adding
    } catch (error) {
      debugger  
      console.error('Error adding nurse:', error);
    }
  };  

  return (
    <div>
      <h2>Add New Nurse</h2>
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
        <button type="submit">Add Nurse</button>
      </form>
    </div>
  );
}
