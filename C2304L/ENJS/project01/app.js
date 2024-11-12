const express = require('express');
const app = express();

// Middleware để xử lý JSON
app.use(express.json());

// Import các router
const nursesRouter = require('./routes/nurses');
const wardsRouter = require('./routes/wards');

// Sử dụng các router
app.use('/api/nurses', nursesRouter);
app.use('/api/wards', wardsRouter);

// Export ứng dụng để sử dụng trong main.js
module.exports = app;
