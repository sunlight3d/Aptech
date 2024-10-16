import React from 'react'
import { useEffect } from 'react'
import { useState } from 'react'

//functional component
const Ward = () => {  
  const [count, setCount] = useState(0)  
  useEffect(()=>{
    const interval = setInterval(()=>{
        setCount(function(count) {
            return count + 1;
        })
        //count = count + 1 => NO!
        
      }, 1000)
      return () => clearInterval(interval);
  }, [])
  
  return (
    <div>
        <div>Ward</div>
        <h1>{count}</h1>
    </div>
    
  )
}

export default Ward