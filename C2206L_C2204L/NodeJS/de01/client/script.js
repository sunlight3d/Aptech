const baseUrl = 'http://localhost:3001/api'
document.addEventListener('DOMContentLoaded', () => {
    debugger
    const studentForm = document.getElementById('studentForm');
    const studentTable = document.getElementById('studentTable');

    // Sự kiện khi form được nộp (submit)
    studentForm.addEventListener('submit', async (e) => {        
        e.preventDefault();
        debugger
        // Lấy dữ liệu từ form
        const formData = new FormData(studentForm);
        const studentData = {
            name: formData.get('name'),
            age: parseInt(formData.get('age')),
            address: formData.get('address'),
            javaScore: parseFloat(formData.get('javaScore')),
            cSharpScore: parseFloat(formData.get('cSharpScore'))
        };

        // Gửi yêu cầu POST để thêm sinh viên mới
        try {
            const response = await fetch(`${baseUrl}/students`, {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(studentData)
            });
            debugger
            if (response.ok) {
                // Nếu thêm thành công, làm mới danh sách sinh viên
                fetchStudentList();
                studentForm.reset();
            } else {
                console.error('Thêm sinh viên mới không thành công.');
            }
        } catch (error) {
            console.error('Lỗi khi gửi yêu cầu:', error);
        }
    });

    // Sự kiện khi nút xóa được nhấn
    studentTable.addEventListener('click', async (e) => {
        debugger
        if (e.target.matches('.delete-button')) {
            if (confirm('Bạn có chắc chắn muốn xóa sinh viên này không?')) {
                const studentId = e.target.dataset.studentId;
                // Gửi yêu cầu DELETE để xóa sinh viên
                try {
                    const response = await fetch(`${baseUrl}/students/${studentId}`, {
                        method: 'DELETE'
                    });

                    if (response.ok) {
                        // Nếu xóa thành công, làm mới danh sách sinh viên
                        fetchStudentList();
                    } else {
                        console.error('Xóa sinh viên không thành công.');
                    }
                } catch (error) {
                    console.error('Lỗi khi gửi yêu cầu:', error);
                }
            }
        }
    });

    // Hàm để lấy danh sách sinh viên và hiển thị trên trang
    async function fetchStudentList() {
        try {
            debugger
            const response = await fetch(`${baseUrl}/students`);
            if (response.ok) {
                const students = await response.json();
                const tbody = studentTable.querySelector('tbody');
                tbody.innerHTML = '';

                students.forEach((student) => {
                    const row = document.createElement('tr');
                    const {id, name, age, address, javaScore, cSharpScore} = student
                    row.innerHTML = `
                        <td>${id}</td>
                        <td>${name}</td>
                        <td>${age}</td>
                        <td>${address}</td>
                        <td>${javaScore}</td>
                        <td>${cSharpScore}</td>
                        <td>
                            <button 
                                class="delete-button" 
                                data-student-id="${id}">Xóa</button>
                        </td>
                    `;
                    tbody.appendChild(row);
                });
            } else {
                console.error('Lấy danh sách sinh viên không thành công.');
            }
        } catch (error) {
            console.error('Lỗi khi gửi yêu cầu:', error);
        }
    }

    // Khi trang được tải, lấy danh sách sinh viên lần đầu
    fetchStudentList();
});
