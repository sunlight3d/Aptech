import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

export default function UpdateNurse() {
  const { nurseId } = useParams();
  const [nurse, setNurse] = useState({
    name: '',
    certification: '',
    wardId: ''
  });
  const navigate = useNavigate();

  useEffect(() => {
    // Giả sử bạn gọi API để lấy thông tin nurse theo ID
    console.log(`Fetching nurse with ID: ${nurseId}`);
    // Giả sử API trả về dữ liệu, set lại state
    setNurse({
      name: 'Tên giả định',
      certification: 'Chứng nhận giả định',
      wardId: 'Ward giả định'
    });
  }, [nurseId]);

  const handleSubmit = (e) => {
    e.preventDefault();
    // Thêm logic xử lý cập nhật y tá tại đây, ví dụ gọi API PUT
    console.log("Updating nurse:", nurse);
    navigate('/'); // Quay lại trang chính sau khi cập nhật
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
