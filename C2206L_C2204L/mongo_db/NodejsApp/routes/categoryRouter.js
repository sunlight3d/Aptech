// Import Express và tạo một đối tượng Router
const express = require('express');
const router = express.Router();
const categoryModel = require('../models/category');


// Router cho thực thể Category
//api url: http://localhost:3000/api/v1/categories
debugger
router.get('/categories', async (req, res) => {
  // Xử lý logic để lấy danh sách category từ database  
  debugger
  const categories = await categoryModel.getAllCategories()
  res.status(200).json(categories);
});
debugger
router.post('/categories', async (req, res) => {
  // Xử lý logic để tạo mới category trong database
  // Ví dụ:
  const newCategory = req.body; // Lấy dữ liệu từ request body
  // Thực hiện lưu newCategory vào database

  res.status(201).json(newCategory);
});

// Router cho thực thể Product
router.get('/products', async (req, res) => {
  // Xử lý logic để lấy danh sách product từ database
  // Ví dụ:
  const products = ['Product 1', 'Product 2', 'Product 3'];
  res.json(products);
});

router.post('/products', (req, res) => {
  // Xử lý logic để tạo mới product trong database
  // Ví dụ:
  const newProduct = req.body; // Lấy dữ liệu từ request body
  // Thực hiện lưu newProduct vào database

  res.status(201).json(newProduct);
});

// Xuất router để sử dụng từ file khác
module.exports = router;
