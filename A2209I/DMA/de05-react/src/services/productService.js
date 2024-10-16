const API_HOST = import.meta.env.VITE_API_HOST;
const API_PORT = import.meta.env.VITE_API_PORT;
const BASE_URL = `${API_HOST}:${API_PORT}/api/Products`;

const fetchProducts = async ({ pageNumber, pageSize }) => {
  try {
    const url = `${BASE_URL}?pageNumber=${pageNumber}&pageSize=${pageSize}`;
    const response = await fetch(url, {
      method: 'GET',
      headers: {
        'Accept': 'application/json', // Updated to accept JSON
      },
    });
    if (!response.ok) {
      throw new Error('Network response was not ok');
    }
    const data = await response.json();
    return data.products;  // Ensure that this matches the actual key in your response
  } catch (error) {
    console.error('Error fetching products:', error);
    return [];
  }
};

export const productService = {
  fetchProducts
};
