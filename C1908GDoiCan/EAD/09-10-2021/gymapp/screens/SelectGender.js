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
import AsyncStorage from '@react-native-async-storage/async-storage'

const SelectGender = (props) => {
    const {navigation} = props
    const [genders, setGenders] = useState([
        {
            icon: icons.male,
            text: 'Male',
            isSelected: true
        },
        {
            icon: icons.female,
            text: 'Female',
            isSelected: false
        },
        {
            icon: icons.nonBinary,
            text: 'Non binary',
            isSelected: false
        }
    ])

    return <SafeAreaView style={{
            backgroundColor: 'white',
            flex: 1,
            flexDirection: 'column'
        }}>
        <UIHeader onPressBack = {() => {
            navigation.goBack()
        }} title = {''}/>                    
        <View style={{
            flex: 1, 
            justifyContent: 'flex-start', 
            alignItems: 'center',            
        }}>
            <UIText style={{                    
                fontSize: fonts.h1 * 1.5,                
                paddingHorizontal: 20,
                textAlign: 'center',            
                marginTop: 20,
                fontWeight: 'bold',
                width: windowWidth / 2
            }}>
                What's your gender ?
        </UIText>   
        </View>
        <View style={{flex: 1}}>            
            {genders.map(genderObject => 
                <TouchableOpacity            
                    key={genderObject.text}     
                    onPress={()=>{                                                                        
                        setGenders(genders.map(item => {
                            return {...item, isSelected: genderObject.text == item.text}
                        }))
                    }}
                    style={{
                        flex: 1,
                        flexDirection: 'row',
                        justifyContent: 'flex-start',
                        alignItems: 'center',
                        marginHorizontal: 20,
                        borderColor: colors.primary,
                        borderWidth: genderObject.isSelected ? 1 : 0,
                        paddingHorizontal: 10,
                        borderRadius: 15,
                        marginBottom: 10
                    }}>
                    <Image
                        source={genderObject.icon}
                        style={{ 
                            width: 30, 
                            height: 30, 
                            tintColor: colors.orange, 
                            marginRight: 5,
                        }}
                    />
                    <UIText style={{                    
                        fontSize: fonts.h3,                                                            
                    }}>
                            {genderObject.text}
                    </UIText>   
                </TouchableOpacity>
            )}
            <View style={{flex: 1, marginBottom: 15}}></View>
            <TouchableOpacity style={{
                position:'absolute',
                bottom: 10,
                left: 20,
                right: 20,                
                height: 50, 
                borderRadius: 25,
                justifyContent: 'center', alignItems: 'center',
                backgroundColor: colors.primary
                }}
                onPress = {async ()=>{
                    const gender = genders.find(gender => gender.isSelected == true).text
                    await AsyncStorage.setItem("gender", gender)
                    navigation.navigate("SelectGoal")                 
                }}
                > 
                <UIText style={{color: 'white', fontWeight: 'bold', fontSize: fonts.h3}}>
                    NEXT
                </UIText>
            </TouchableOpacity>
        </View>
    </SafeAreaView>
}
export default SelectGender