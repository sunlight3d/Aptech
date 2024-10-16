import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'

import Home from './screens/Home.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    {/* <App /> */}
    <Home />
  </StrictMode>,
)
