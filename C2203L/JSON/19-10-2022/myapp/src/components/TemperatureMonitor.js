import React, { useState } from 'react'
export function TemperatureMonitor(props) {
    const [temperatures, setTemperatures] = useState([])
    const [currentTemperature, setCurrentTemperature] = useState(0)
    const [medianTemperature, setMedianTemperature] = useState(0)
    return <div>
        <h1>Temperature Monitor</h1>
        <span>Add Temperature: </span> 
        <input placeholder='Enter temperature' 
            value={currentTemperature}
            onChange = {(event) => {                
                setCurrentTemperature(event.target.value)                                
            }}
            />
        <button onClick={()=>{
            //temperatures.push(currentTemperature)
            debugger
            if(!temperatures.find(item => item == currentTemperature)) {
                    setTemperatures(temperatures.concat(currentTemperature))        
            }            
        }}>Add</button>
        <p>Current state of the list: {temperatures.join(', ')} </p>
        <button onClick={(event)=>{
            let total = 0.0
            debugger
            /*
            for(let i = 0; i < temperatures.length; i++) {
                total += parseFloat(temperatures[i])
            }
            */
           temperatures.forEach(item => {
            total += parseFloat(item)
           })
            setMedianTemperature(temperatures.length == 0 ? 0 : total / temperatures.length)
        }}>Get median temperature</button>
        <p>Medianss = {medianTemperature}</p>

    </div>
}