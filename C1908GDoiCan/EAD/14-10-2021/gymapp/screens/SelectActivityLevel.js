import React, { useState, useEffect } from 'react'
import { 
    View, 
    TextInput,
    Image,
    StyleSheet,
    Dimensions,
    TouchableOpacity,
    SafeAreaView,
    FlatList,
    TouchableHighlight
} from "react-native"

import Slider from '@react-native-community/slider'
import {colors, images, fonts, sizes, icons} from '../constants'
const {windowWidth, windowHeight} = sizes
import UIText from "../widgets/UIText"
import UIHeader from "../widgets/UIHeader"
import { NavigationContainer } from '@react-navigation/native'
const SelectActivityLevel = (props) => {
    const [level, setLevel] = useState('Newbie')
    const {navigation} = props    
    return <SafeAreaView style={{
            flex: 90, 
            justifyContent: 'flex-start',            
        }}>
        <View style={{
            flex: 30, 
            justifyContent: 
            'space-between',            
        }}>
            <View>
                <UIHeader title={""} onPressBack={()=>{
                    
                }}/>
                <UIText style={{                    
                        fontSize: fonts.h1 * 1.5,                
                        paddingHorizontal: 50,
                        textAlign: 'center',            
                        marginVertical: 10,
                        fontWeight: 'bold',                     
                    }}>
                        What's your current activity level ?
                </UIText>                
            </View>            
        </View>
        <View style={{
            flex: 30,             
            justifyContent: 'center', 
            alignItems:'center'
        }}>
            <UIText style={{fontSize: fonts.h3, fontWeight: 'bold'}}>
                {level}
            </UIText> 
            <Slider
                style={{width: '100%', height: 40 }}
                minimumValue={0}
                maximumValue={1}
                minimumTrackTintColor={colors.orange}
                maximumTrackTintColor={colors.primary}
                onValueChange = {(text) => {
                    let _level = parseFloat(text)                    
                    if(_level >=0 && _level <= 0.4) {
                        setLevel("Newbie")
                    } else if(_level > 0.4 && _level < 0.6){
                        setLevel("Medium")
                    } else if(_level >= 0.6){
                        setLevel("Pro")
                    }
                    
                }}
                />

        </View>
        <View style={{flex: 30}}>
        
            <TouchableOpacity style={{
                backgroundColor: colors.primary,          
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
                    
                }}
            >
                <UIText style={{
                    color: 'white',
                }}>NEXT</UIText>
            </TouchableOpacity>
        </View>
    </SafeAreaView>
}
export default SelectActivityLevel