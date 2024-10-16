import React from 'react'
import 'bootstrap/dist/css/bootstrap.min.css'
import ReactDOM from 'react-dom/client'
import Main from './screens/Main'
import StudentListFromApi from './screens/StudentListFromApi'
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <Main /> */}
    <StudentListFromApi />
  </React.StrictMode>
)
/*
yarn add react-bootstrap bootstrap
yarn add react-datepicker
*/