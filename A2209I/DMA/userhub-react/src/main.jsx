import React from 'react';
import * as ReactDOM from "react-dom/client";
import { createBrowserRouter, RouterProvider } from "react-router-dom";

import Login from './screens/Login';
import Home from './screens/Home';
import AddPost from './screens/AddPost';
import EditPost from './screens/EditPost';

// Since you commented out the CSS import, ensure you handle global styles accordingly.
// import './index.css';

/**
 * Setup commands noted for reference:
 * npm create vite@latest userhub-react -- --template react
 * npm run dev
 * npm install react-router-dom
 */

const router = createBrowserRouter([
  {
    path: "/",
    element: <Home />,
  },
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "/posts/new", // Changed for clarity: distinct path for adding a new post.
    element: <AddPost />,
  },
  {
    path: "/posts/:id", // Assuming dynamic ID for editing posts.
    element: <EditPost />,
  },
]);

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

