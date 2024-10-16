import React from "react"
import { 
    Text,   
    View,
    Image,
    TouchableOpacity, 
} from "react-native"
import {colors, images, fonts, sizes, icons} from '../constants'
import UIText from "./UIText"
const UIHeader = (props) => 
    (<View style={{ 
        flexDirection: 'row', 
        justifyContent: 'space-between',
        alignItems: 'center',
        paddingVertical: 10,
        paddingHorizontal: 10,
     }}>
        <TouchableOpacity onPress={props.onPressBack}>
            <Image
                source={icons.back}
                style={{ width: 40, height: 40 }}
            />
        </TouchableOpacity>        
        <UIText style={{ textAlign: 'center' }}>
            {props.title}
        </UIText>
        <View style={{ width: 50, height: 50 }} />
    </View>)
export default UIHeader    