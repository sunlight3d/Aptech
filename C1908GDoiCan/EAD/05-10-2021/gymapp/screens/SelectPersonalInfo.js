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

const SelectPersonalInfo = (props) => {
    const {navigation} = props    
    const [goals, setGoals] = useState([
        {
            icon: icons.loseWeight,
            title: 'Lose weight',
            description: 'Drop extra pounds',
            isSelected: true
        },
        {
            icon: icons.buildMuscle,
            title: 'Build Muscle',
            description: 'Make your health to be strong',
            isSelected: false
        },
        {
            icon: icons.keepFit,
            title: 'Keep Fit',
            description: 'Stay in shape and feel great',
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
                paddingHorizontal: 50,
                textAlign: 'center',            
                marginTop: 20,
                fontWeight: 'bold',                
            }}>
                What is your main goal?
        </UIText>   
        </View>
        <View style={{flex: 1}}>            
            {goals.map(genderObject => 
                <TouchableOpacity            
                    key={genderObject.text}     
                    onPress={()=>{                                                                        
                        setGoals(goals.map(item => {
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
                            width: 22, 
                            height: 22, 
                            tintColor: colors.orange, 
                            marginRight: 10,
                        }}
                    />
                    <View style={{
                        flexDirection:'column',                        
                    }}>
                        <UIText style={{                    
                            fontSize: fonts.h3,                                                            
                        }}>
                                {genderObject.title}
                        </UIText>   
                        <UIText style={{                    
                            fontSize: fonts.h3,                                                            
                            color: colors.inactive
                        }}>
                                {genderObject.description}
                        </UIText>   
                    </View>
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
                    const goal = goals.find(goal => goal.isSelected == true).text
                    await AsyncStorage.setItem("goal", goal)
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
export default SelectGoal