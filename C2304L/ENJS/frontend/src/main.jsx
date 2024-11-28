import { StrictMode } from 'react'
import React from 'react';
import TaskList from './pages/Task/TaskList'
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

//man hinh = component
import AddNewTask from './pages/Task/AddNewTask';
import UpdateTask from './pages/Task/UpdateTask';

const router = createBrowserRouter([
  {
    path: "/",    
    element: <TaskList />,
  },
  {
    path: "/add-new",
    element: <AddNewTask />,
  },
  {
    path: "/update/:taskId",
    element: <UpdateTask />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
