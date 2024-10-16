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
const InputHeight = (props) => {

    const [selectedUnit, setSelectedUnit] = useState('cm')
    const [height, setHeight] = useState('0')
    const [error, setError] = useState('')
    const cmToFeet = (cm) => isNaN(cm) ? '' : 0.032808399 * cm
    const feetToCM = (feet) => isNaN(feet) ? '' : 30.48 * feet 
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
                Your height
        </UIText>
        <View style={{
            height: 45,
            width: windowWidth / 2.5,            
            borderRadius: 45 / 2,
            alignSelf: 'center',
            margin: 10,
            borderColor: colors.primary,
            borderWidth: 1,
            flexDirection: 'row',
        }}>
            <TouchableOpacity style={{
                backgroundColor: selectedUnit == 'cm' ? 'white' : colors.primary, 
                flex: 1, 
                borderBottomLeftRadius: 45 / 2,
                borderTopLeftRadius: 45 / 2,
                justifyContent: 'center',      
                alignItems: 'center',                
            }} onPress={() => {
                if(selectedUnit == 'cm' && error == '') {
                    setHeight(`${cmToFeet(parseFloat(height))}`)
                }                
                setSelectedUnit('ft')                
            }}><UIText style={{
                color: selectedUnit != 'cm' ? 'white' : colors.primary, 
            }}>FT</UIText></TouchableOpacity>
            <TouchableOpacity style={{
                backgroundColor: selectedUnit == 'cm' ? colors.primary : 'white', 
                flex: 1,
                borderBottomRightRadius: 45 / 2,
                borderTopRightRadius: 45 / 2,          
                justifyContent: 'center',      
                alignItems: 'center',
            }} onPress={() => {
                if(selectedUnit == 'ft' && error == '') {
                    setHeight(`${feetToCM(parseFloat(height))}`)
                }                
                setSelectedUnit('cm')
            }}><UIText style={{
                color: selectedUnit == 'cm' ? 'white' : colors.primary, 
            }}>CM</UIText></TouchableOpacity>
        </View>
        <View style={{flexDirection: 'row', alignSelf: 'center', alignItems: 'flex-end'}}>
            <View>
                <TextInput 
                    keyboardType = 'numeric'
                    style={{
                        marginTop:50,
                        fontSize: 40,
                        textAlign: 'center',
                        fontWeight: 'bold',                
                    }}
                    onChangeText = {(text) => {
                        let filteredText = text.replace(/-/g,'')
                                        .replace(/\s/g,'')                                        
                                        .replace(/,/g,'')                                          
                        debugger                
                        const isMatch = selectedUnit == 'cm' ? filteredText.match(/^[0-9]{1,3}$/g) 
                                                            && parseFloat(filteredText) < 200 
                                                            && parseFloat(filteredText) > 100 
                        : filteredText.match(/^[0-9]{1,3}$/g) 
                            && cmToFeet(parseFloat(filteredText) < 6.26)
                            && cmToFeet(parseFloat(filteredText) > 3.25)

                        setError(isMatch ? '' : "Length must be 1m -> 2m")                                                                   
                        setHeight(filteredText.replace(/[a-zA-Z]+/g,''))                                 
                    }}
                    value={selectedUnit ==  'cm' ? `${!isNaN(parseFloat(height)) ? parseFloat(height).toFixed(0) : ''}` : 
                                            `${!isNaN(parseFloat(height)) ? parseFloat(height).toFixed(2) : ''}`}>                
                </TextInput>
                <View style={{
                    height: 1.5, 
                    backgroundColor: error =='' ? colors.primary:colors.red,
                    width: windowWidth / 2,            
                    alignSelf: 'center'
                }} />                
            </View> 
            <UIText style={{
                paddingHorizontal: 5, 
                paddingBottom: 15,
                fontSize: fonts.h1,
                fontWeight: 'bold'
            }}>{selectedUnit}</UIText>
        </View>           
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
                navigation.navigate('SelectBodyType')
            }}
        >
            <UIText style={{
                color: 'white',
            }}>NEXT</UIText>
        </TouchableOpacity>
    </SafeAreaView>
}
export default InputHeight