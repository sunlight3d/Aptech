import React from 'react'
function Header(props) {    
    const {name, age} = props
    return <h1>Day la header, name = {name}, age = {age}</h1>
}
export default Header