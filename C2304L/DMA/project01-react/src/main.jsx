import { StrictMode } from 'react'
import React from 'react';
import { createRoot } from 'react-dom/client'
import NurseList from './pages/Nurse/NurseList'
import * as ReactDOM from "react-dom/client";
import {
  createBrowserRouter,
  RouterProvider,
} from "react-router-dom";

import AddNewNurse from './pages/Nurse/AddNewNurse';
import UpdateNurse from './pages/Nurse/UpdateNurse';

const router = createBrowserRouter([
  {
    path: "/",    
    element: <NurseList />,
  },
  {
    path: "/add-new",
    element: <AddNewNurse />,
  },
  {
    path: "/update/:nurseId",
    element: <UpdateNurse />,
  },
]);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
