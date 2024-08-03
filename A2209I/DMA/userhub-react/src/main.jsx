import React from 'react'
import ReactDOM from 'react-dom/client'
import Login from './screens/Login'
import Home from './screens/Home'
//import './index.css'
/**
 npm create vite@latest userhub-react -- --template react
 npm run dev
 */
ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    {/* <Login /> */}
    <Home />
  </React.StrictMode>,
)
