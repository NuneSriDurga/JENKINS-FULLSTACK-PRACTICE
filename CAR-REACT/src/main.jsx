import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
// import './index.css'
import App from './App.jsx'
import CarManager from './components/CarManager.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>
    <CarManager />
  </StrictMode>,
)
