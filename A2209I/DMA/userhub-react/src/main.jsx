import React from 'react'
import ReactDOM from 'react-dom/client'
import Login from './screens/Login'
import Home from './screens/Home'
import AddPost from './screens/AddPost'
import EditPost from './screens/EditPost'
//import './index.css'
/**
 npm create vite@latest userhub-react -- --template react
 npm run dev
 */
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <Login /> */}
    {/* <Home /> */}
    {/* <AddPost />  */}
    <EditPost id = {6}/>
  </React.StrictMode>,
)
