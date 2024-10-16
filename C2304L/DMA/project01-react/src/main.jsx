import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import Ward from './pages/Ward/Ward'
createRoot(document.getElementById('root')).render(
  <StrictMode>
    <Ward />
  </StrictMode>,
)
