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
const SelectBodyType = (props) => {
    const [bodyShapes, setBodyShapes] = useState([
        {
            icon: icons.iconBodyShapeThin,
            text: 'Thin',
            isSelected: false,
        },
        {
            icon: icons.iconBodyShapeNormal,
            text: 'Normal',
            isSelected: true,
        },
        {
            icon: icons.iconBodyShapeFat,
            text: 'Fat',
            isSelected: false,
        }
    ])
    const {navigation} = props
    return <SafeAreaView style={{
            flex: 10, 
            justifyContent: 'flex-start',            
        }}>
        <View style={{flex: 8.5, justifyContent: 'space-between'}}>
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
                        Body Type
                </UIText>
                <UIText style={{
                    fontSize: fonts.h2,
                    color: colors.inactive,
                    textAlign: 'center',
                }}>
                    Which image do you like most ?
                </UIText>
            </View>
            <View style={{
                height: 200,
                flexDirection: 'row',      
                paddingHorizontal: 10,                          
            }}>
                {bodyShapes.map(bodyShape => <TouchableOpacity 
                key = {bodyShape.text}
                style={{
                    flex: 1,                     
                    justifyContent: 'center',
                    alignItems: 'center',
                    borderRadius: 10,
                    borderWidth: bodyShape.isSelected == true ? 1 : 0,
                    borderColor: colors.primary,                    
                }} onPress = {() => {                    
                    setBodyShapes(bodyShapes.map(item => {
                        return {...item, isSelected: bodyShape.text == item.text}
                    }))
                }}>
                    <Image
                            source={bodyShape.icon}
                            style={{ 
                                width: 50, 
                                height:100, 
                                tintColor: colors.orange, 
                                marginBottom: 10                                
                            }}
                        />
                    <UIText style={{
                        fontSize: fonts.h4,                        
                        textAlign: 'center',
                    }}>
                        {bodyShape.text}
                    </UIText>
                </TouchableOpacity>)}          
            </View>
        </View>
        <View style={{flex: 1.5}}>
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
                    navigation.navigate('SelectIngredients')
                }}
            >
                <UIText style={{
                    color: 'white',
                }}>NEXT</UIText>
            </TouchableOpacity>
        </View>
    </SafeAreaView>
}
export default SelectBodyType