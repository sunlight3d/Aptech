import { useState } from 'react'

function App() { 
  //functional component
  const [count, setCount] = useState(0) //local state
  const [personname, setPersonName] = useState('')

  return (
    <>
      
      <h1>Vite + React</h1>
      <div className="card">
        <button onClick={() => {
          setCount((count) => count + 1)
          setPersonName('Hoang');
        }}>
          count is {count}
        </button>
        <p>
          Edit <code>src/App.jsx</code> and save to test HMR
        </p>
      </div>
      <p className="read-the-docs">
        {personname}
      </p>
    </>
  )
}

export default App
