import { useState } from "react"

function Part1() {
    //JSX
    const [name, setName] = useState("") //state is "immutable"
    return <div>
        <h1>This is Part1</h1>
        <p>Name:</p>
        <input 
            type={"text"} 
            //props
            value={name}
            onChange={(event) => {
                //debugger
                //name = event.target.value //NO !
                setName(event.target.value)
                console.log(name)
            }}
            placeholder={"Enter name"}
            >
        </input>
        <p>You wrote: {name}</p>
    </div>
}
export default Part1