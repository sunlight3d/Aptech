const { MongoClient } = require('mongodb');

// Thông tin kết nối đến MongoDB
const uri = process.env.MONGODB_URI || 'mongodb://localhost:27017'; // Sử dụng biến môi trường hoặc giá trị mặc định
const dbName = process.env.DB_NAME || 'mydatabase'; // Sử dụng biến môi trường hoặc giá trị mặc định

// Tạo kết nối và xuất module để sử dụng từ file khác
async function connectToDatabase() {  
  const client = new MongoClient(uri, { useNewUrlParser: true, useUnifiedTopology: true });

  try {
    // Kết nối tới MongoDB
    await client.connect();    
    console.log('Kết nối thành công đến MongoDB');
    // Chọn database
    const db = client.db(dbName);
    // Xuất đối tượng db để sử dụng từ file khác
    return db;
  } catch (error) {    
    console.error('Lỗi kết nối MongoDB:', error);
    throw error;
  }
}
// Xuất hàm connectToDatabase để sử dụng từ file khác
module.exports = connectToDatabase;
