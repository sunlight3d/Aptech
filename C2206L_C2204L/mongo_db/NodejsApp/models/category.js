const { ObjectId } = require('mongodb');
const connectToDatabase = require('../database'); // Import module để kết nối tới MongoDB

// Hàm tạo một category mới
const createCategory = async (category) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const result = await db.collection("categories").insertOne(category);
  return result.insertedId;
};

// Hàm lấy danh sách tất cả các categories
const getAllCategories = async () => {
  const db = await connectToDatabase(); // Kết nối đến database
  const categories = await db.collection("categories").find().toArray();
  return categories;
};

// Hàm lấy một category theo id
const getCategoryById = async (categoryId) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const category = await db.collection("categories").findOne({ _id: ObjectId(categoryId) });
  return category;
};

// Hàm cập nhật một category
const updateCategory = async (categoryId, updates) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const result = await db.collection("categories").updateOne(
    { _id: ObjectId(categoryId) },
    { $set: updates }
  );
  return result.modifiedCount;
};

// Hàm xóa một category
const deleteCategory = async (categoryId) => {
  const db = await connectToDatabase(); // Kết nối đến database
  const result = await db.collection("categories").deleteOne({ _id: ObjectId(categoryId) });
  return result.deletedCount;
};

module.exports = {
  createCategory,
  getAllCategories,
  getCategoryById,
  updateCategory,
  deleteCategory
};
