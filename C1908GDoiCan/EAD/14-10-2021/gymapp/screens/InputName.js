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
import {colors, images, fonts, sizes, icons} from '../constants'
const {windowWidth, windowHeight} = sizes
import UIText from "../widgets/UIText"
import UIHeader from "../widgets/UIHeader"
import { NavigationContainer } from '@react-navigation/native'
const InputName = (props) => {
    const [name, setName] = useState('')
    const [error, setError] = useState('')
    const {navigation} = props
    return <SafeAreaView style={{
            flex: 1, 
            justifyContent: 'flex-start',            
        }}>
        <UIHeader title={""} onPressBack={()=>{
            
        }}/>
        <UIText style={{                    
                fontSize: fonts.h1 * 1.5,                
                paddingHorizontal: 50,
                textAlign: 'center',            
                marginTop: 20,
                fontWeight: 'bold',                
            }}>
                What's your name ?
        </UIText>
        <TextInput 
            keyboardType = 'numeric'
            style={{
                marginTop:50,
                fontSize: 40,
                textAlign: 'center',
                fontWeight: 'bold',                
            }}
            onChangeText = {(text) => {
                if(text.match('[a-zA-Z]{1}[a-zA-Z0-9]{2,}$')) {
                    setError('')
                } else {
                    setError('Name must be at least 3 characters')
                }
                setName(text)
            }}
            value={name} >                
        </TextInput>
        <View style={{
            height: 1.5, 
            backgroundColor: error =='' ? colors.primary:colors.red,
            width: windowWidth / 2,            
            alignSelf: 'center'
        }} />        
        <UIText style={{                    
                fontSize: fonts.h3,                                
                marginTop: 10,
                color: colors.red,
                textAlign: 'center'
            }}>
                {error}
        </UIText>
        <TouchableOpacity style={{
            backgroundColor: error == '' ? colors.primary : colors.inactive,            
            justifyContent: 'center',
            alignItems: 'center',
            height: 40,            
            borderRadius: 20,            
            position: 'absolute',
            bottom: 10,
            left: 40,
            right: 40,
        }}
            onPress={() => {
                navigation.navigate('InputAge')
            }}
        >
            <UIText style={{
                color: 'white',
            }}>NEXT</UIText>
        </TouchableOpacity>
    </SafeAreaView>
}
export default InputName