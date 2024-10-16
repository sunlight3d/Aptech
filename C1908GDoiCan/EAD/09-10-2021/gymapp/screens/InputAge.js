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
const InputAge = (props) => {
    const [age, setAge] = useState('')
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
                How old are you ?
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
                //exclude: - ,.                
                let filteredText = text.replace(/-/g,'')
                                        .replace(/\s/g,'')
                                        .replace(/\./g,'')
                                        .replace(/,/g,'')    
                filteredText = filteredText.substring(0, 2)  
                const isValidYear = parseInt(filteredText) >= 13                 
                if(isValidYear) {
                    setError('')
                    setAge(filteredText)
                } else {
                    setError('You must be 13 years or older')
                }                
            }}
            value={age} >                
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
                navigation.navigate('InputName')
            }}
        >
            <UIText style={{
                color: 'white',
            }}>NEXT</UIText>
        </TouchableOpacity>
    </SafeAreaView>
}
export default InputAge