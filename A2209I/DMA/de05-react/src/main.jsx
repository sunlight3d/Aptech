import React from 'react'
import ReactDOM from 'react-dom/client'
import Home from './components/Home.jsx'
import DetailProduct from './components/DetailProduct.jsx';
import EditProduct from './components/EditProduct.jsx';

import './index.css'
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";


const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/product/:productId",
    element: <DetailProduct />,
  },
  {
    path: "/product/:productId/edit",
    element: <EditProduct />,
  },
]);

/**
 npm install -D vite
 yarn create vite de05-react --template react
 npm install -D tailwindcss postcss autoprefixer
 */
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
     <RouterProvider router={router} />    
  </React.StrictMode>,
)
