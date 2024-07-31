// src/api/apiClient.js
import axios from 'axios';

const apiClient = axios.create({
  baseURL: 'https://localhost:5001',
  headers: {
    'Content-Type': 'application/json',
  },
});

export default apiClient;
