/**
 yarn add react-router-dom axios cors

 */
import React from 'react'
import ReactDOM from 'react-dom/client'
//import App from './App.js'
import StudentList from './screens/StudentList'
import InsertStudent from './screens/InsertStudent'
import UpdateStudent from './screens/UpdateStudent'
import { BrowserRouter, Route,  Routes } from 'react-router-dom';

ReactDOM.createRoot(document.getElementById('root')).render(
  <BrowserRouter>
    <Routes>    
      <Route path="/" element={<StudentList />} />
      <Route path="/add-new" element={<InsertStudent />} />           
      <Route path="/update/:id" element={<UpdateStudent />} />           
    </Routes>
  </BrowserRouter>
  
  
)
