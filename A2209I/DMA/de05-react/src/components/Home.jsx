import React, { useState, useEffect } from 'react';
import { productService } from '../services/productService';

function Home() {
  const [products, setProducts] = useState([]);
  const [currentPage, setCurrentPage] = useState(1);
  const [productsPerPage] = useState(10); // You can adjust this value
  
  useEffect(() => {
    
    productService.fetchProducts({ 
      pageNumber:currentPage, 
      pageSize:productsPerPage 
    })
      .then(responseProducts => setProducts(responseProducts))
      .catch(error => setProducts([]));    
  }, [currentPage]);

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`http://localhost:5119/api/Products/${id}`, {
        method: 'DELETE',
      });
      if (response.ok) {
        setProducts(products.filter(product => product.id !== id));
      } else {
        throw new Error('Failed to delete the product.');
      }
    } catch (error) {
      console.error('Error deleting product:', error);
    }
  };

  const handleEdit = (id) => {
    
    console.log('Edit product with ID:', id);
    navigate(`/product/${id}/edit`);
  };

  // Function to handle page change
  const handlePageChange = (newPage) => {
    setCurrentPage(newPage);
  };

  return (
    <>
      <h1 className="text-3xl font-bold underline">This is a list of products</h1>
      <div className="overflow-x-auto">
        <table className="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
          <thead className="bg-gray-50">
            <tr>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Id</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Name</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Price</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Description</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Quantity</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Edit</th>
              <th className="px-6 py-3 border-b border-gray-200 text-gray-800 text-left text-sm uppercase font-normal">Delete</th>
            </tr>
          </thead>
          <tbody>
            {products.map((product) => (
              <tr key={product.id}>
                <td className="px-6 py-4 border-b border-gray-200 text-sm text-black">{product.id}</td>
                <td className="px-6 py-4 border-b border-gray-200 text-sm text-black">{product.name}</td>
                <td className="px-6 py-4 border-b border-gray-200 text-sm text-black">{product.price}</td>
                <td className="px-6 py-4 border-b border-gray-200 text-sm text-black">{product.description}</td>
                <td className="px-6 py-4 border-b border-gray-200 text-sm text-black">{product.quantity}</td>
                <td className="px-6 py-4 border-b border-gray-200 text-center">
                  <button onClick={() => handleEdit(product.id)} className="text-blue-500 hover:text-blue-700">Edit</button>
                </td>
                <td className="px-6 py-4 border-b border-gray-200 text-center">
                  <button onClick={() => handleDelete(product.id)} className="text-red-500 hover:text-red-700">Delete</button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
      <div className="pagination">
        <button onClick={() => handlePageChange(currentPage - 1)} disabled={currentPage === 1}>
          Previous
        </button>
        <span>Page {currentPage}</span>
        <button onClick={() => handlePageChange(currentPage + 1)}>
          Next
        </button>
      </div>
    </>
  );
}

export default Home;
