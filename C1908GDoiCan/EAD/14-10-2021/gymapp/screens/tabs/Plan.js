import React, { useState, useEffect } from 'react'
import { 
    View, 
    TextInput,
    Image,
    StyleSheet,
    Dimensions,
    TouchableOpacity,
    SafeAreaView,
} from "react-native"
import {colors, images, fonts, sizes, icons} from '../../constants'
const {windowWidth, windowHeight} = sizes
import UIText from "../../widgets/UIText"

const Plan = (props) => {    
    //const {navigation} = props
    return <SafeAreaView style={{
            flex: 1, 
            justifyContent: 'center',
            alignItems: 'center'
        }}>        
        <UIText style={{                    
                fontSize: fonts.h1 * 1.5,                                
        }}>
                This is Plan
        </UIText>
        
                
    </SafeAreaView>
}
export default Plan