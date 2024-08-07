import React from 'react'
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

import Login from './screens/Login'
import Home from './screens/Home'
import AddPost from './screens/AddPost'
import EditPost from './screens/EditPost'

//import './index.css'
/**
 npm create vite@latest userhub-react -- --template react
 npm run dev
 npm install react-router-dom
 */
 const router = createBrowserRouter([
  {
    path: "/login",
    element: <Login />,
  },
  {
    path: "posts/:id",
    element: <EditPost />,
  },
  {
    path: "posts",
    element: <AddPost />,
  },
  {
    path: "addPost",
    element: <AddPost />,
  },
  {
    path: "/",
    element: <Home />,
  },
]);
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <Login /> */}
    {/* <Home /> */}
    {/* <AddPost />  */}
    {/* <EditPost id = {6}/> */}
    <RouterProvider router={router} />
  </React.StrictMode>,
)
