import { useState } from "react"
const getAverage = (someNumbers) => {
    let result = 0.0    
    for(let eachNumber of someNumbers) {
        result += parseFloat(eachNumber)
    }
    return someNumbers.length == 0 
            ? 0 : result / someNumbers.length
}
function Part2() {
    const [temperature, setTemperature] = useState(0)
    const [temperatures, setTemperatures] = useState([])
    return <div>
        <h1>Temperature Monitor</h1>
        <p>Add Temperature</p>
        <input type={"text"} onChange={(event) => {
            setTemperature(event.target.value)
        }} />
        <button onClick={()=>{
            setTemperatures(temperatures.concat(temperature))
            /*
            let clonedTemperatures = [...temperatures]            
            clonedTemperatures.push(temperature)   
            debugger                     
            setTemperatures(clonedTemperatures)
            */

        }}>
            Add
        </button>
        <p>Current values: {JSON.stringify(temperatures)}</p>
        <p>Current temperature: {temperature}</p>
        <p>Average : {getAverage(temperatures)}</p>
    </div>
}
export default Part2