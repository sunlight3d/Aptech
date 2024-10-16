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
    const [height, setHeight] = useState('10')
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
            <View style={{
                backgroundColor: selectedUnit == 'cm' ? 'white' : colors.primary, 
                flex: 1, 
                borderBottomLeftRadius: 45 / 2,
                borderTopLeftRadius: 45 / 2,
                justifyContent: 'center',      
                alignItems: 'center',
            }}><UIText style={{
                color: selectedUnit != 'cm' ? 'white' : colors.primary, 
            }}>FT</UIText></View>
            <View style={{
                backgroundColor: selectedUnit == 'cm' ? colors.primary : 'white', 
                flex: 1,
                borderBottomRightRadius: 45 / 2,
                borderTopRightRadius: 45 / 2,          
                justifyContent: 'center',      
                alignItems: 'center',
            }}><UIText style={{
                color: selectedUnit == 'cm' ? 'white' : colors.primary, 
            }}>CM</UIText></View>
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
                    // onChangeText = {(text) => {
                    //     if(text.match('[a-zA-Z]{1}[a-zA-Z0-9]{2,}$')) {
                    //         setError('')
                    //     } else {
                    //         setError('Name must be at least 3 characters')
                    //     }
                    //     setName(text)
                    // }}
                    value={height} >                
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
            }}>cm</UIText>
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
                //navigation.navigate('InputName')
            }}
        >
            <UIText style={{
                color: 'white',
            }}>NEXT</UIText>
        </TouchableOpacity>
    </SafeAreaView>
}
export default InputHeight