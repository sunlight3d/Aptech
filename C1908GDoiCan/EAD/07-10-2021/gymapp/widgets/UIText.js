import React from "react"
import { 
    Text,    
} from "react-native"
const UIText = (props) => <Text {...props}
    style={[{
        fontFamily: 'Montserrat-Light',               
    }, props.style]}>
        {props.children}
</Text>
export default UIText