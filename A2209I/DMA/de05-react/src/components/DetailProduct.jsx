import React from 'react';
import { useParams } from 'react-router-dom';

function DetailProduct() {
  const { productId } = useParams();
  
  // Fetch product detail using productId

  return (
    <div>
      <h1>Product Detail for {productId}</h1>
      {/* Render product details here */}
    </div>
  );
};

export default DetailProduct;
