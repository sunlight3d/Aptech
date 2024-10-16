const { ObjectId } = require('mongodb');
const connectToDatabase = require('../database'); // Import module để kết nối tới MongoDB

// Hàm tạo một product mới
const createProduct = async (product) => {
  const result = await db().products.insertOne(product);
  return result.insertedId;
};

// Hàm lấy danh sách tất cả các products
const getAllProducts = async () => {  
  const db = await connectToDatabase(); // Kết nối đến database  
  const products = await db.collection("products").find().toArray();  
  return products;
};

// Hàm lấy một product theo id
const getProductById = async (productId) => {
  
  const db = await connectToDatabase(); // Kết nối đến database
  debugger
  const result = await db.collection('products').findOne({_id: new ObjectId(productId)})  
  return result;
};

// Hàm cập nhật một product
const updateProduct = async (productId, updates) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const result = await db.collection("products").updateOne(
    { _id: ObjectId(productId) },
    { $set: updates }
  );
  return result.modifiedCount;
};

// Hàm xóa một product
const deleteProduct = async (productId) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const result = await db.collection("products").deleteOne({ _id: new ObjectId(productId) });
  return result.deletedCount;
};

module.exports = {
  createProduct,
  getAllProducts,
  getProductById,
  updateProduct,
  deleteProduct
};
