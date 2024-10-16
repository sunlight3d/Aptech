import React, {Component, useEffect} from "react"
import ProductList from "./ProductList"
import {useState} from 'react'

function Welcome(props){    
    //const => let => var    
    const {x, y} = props
    const [name, setName] = useState("")//initial state
    //name = "hoang" //NO !!!!
    //setName('Hoang') //YES !

    return <div>
        <h1>Chao cac ban, name = {props.name}, x = {x} y = {y}</h1>   
        Name
        
        <input type={"text"}             
            value={name}
            onChange={(event)=>{
                //debugger
                //2-ways data-binding
                setName(event.target.value)
                console.log(event.target.value)
            }}
            placeholder={"Enter your name"}></input>
        <p>You wrote: {name}</p>
        {/* <ProductList /> */}
    </div>
}
//make "public"
export default Welcome