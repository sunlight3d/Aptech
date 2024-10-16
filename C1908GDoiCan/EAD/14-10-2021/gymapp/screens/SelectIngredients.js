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
import {colors, images, fonts, sizes, icons} from '../constants'
const {windowWidth, windowHeight} = sizes
import UIText from "../widgets/UIText"
import UIHeader from "../widgets/UIHeader"
import { NavigationContainer } from '@react-navigation/native'
const SelectIngredients = (props) => {
    const [ingredients, setIngredients] = useState([
        {
            icon: icons.iconBroccoli,
            text: 'Broccoli',
            isSelected: false,
        },
        {
            icon: icons.iconSweetPotato,
            text: 'Sweet potato',
            isSelected: false,
        },
        {
            icon: icons.iconMushroom,
            text: 'Mushroom',
            isSelected: false,
        },        
        {
            icon: icons.iconTomato,
            text: 'Tomato',
            isSelected: false,
        },
        {
            icon: icons.iconPeas,
            text: 'Peas',
            isSelected: false,
        },
        {
            icon: icons.iconSpinach,
            text: 'Spinach',
            isSelected: false,
        },
        {
            icon: icons.iconSucchini,
            text: 'Succhini',
            isSelected: false,
        },
        {
            icon: icons.iconPepper,
            text: 'Pepper',
            isSelected: false,
        },        
    ])
    const {navigation} = props
    const selectedIngredients = ingredients.filter(ingredient => ingredient.isSelected == true)
    return <SafeAreaView style={{
            flex: 10, 
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
                        Pick the ingredients you wish ?
                </UIText>                
            </View>            
        </View>
        <View style={{flex: 70,}}>
        <FlatList
            data={ingredients}
            renderItem={({ item, index, separators }) => (
                <TouchableOpacity
                    onPress={() => {
                        setIngredients(ingredients.map(ingredient => {
                            return {
                                ...ingredient, 
                                isSelected: ingredient.text == item.text ? !ingredient.isSelected : ingredient.isSelected
                            }
                        }))
                    }}
                    key={item.key}
                    style={{                                                
                        flex: 1,
                        flexDirection: 'row',
                        justifyContent: 'flex-start',
                        alignItems: 'center',
                        margin: 1,
                        paddingHorizontal: 15,
                        paddingVertical: 20,
                        borderRadius: 10,
                        borderWidth: item.isSelected ? 1 : 0,
                        borderColor: colors.primary,       
                        marginHorizontal:10,             
                    }}>
                <Image
                    source={item.icon}
                    style={{ 
                        width: 30, 
                        height:30,                         
                        marginEnd: 10,
                    }}
                />
                <UIText style={{fontSize: fonts.h3}}>{item.text}</UIText>
                </TouchableOpacity>
            )}            
            numColumns={2}
            keyExtractor={(ingredient, index) => ingredient.text}
            />
            <TouchableOpacity style={{
                backgroundColor: selectedIngredients.length > 0 ? colors.primary : colors.inactive,            
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
                    if(selectedIngredients.length > 0){
                        navigation.navigate('MyTab')      
                    }
                    
                }}
            >
                <UIText style={{
                    color: 'white',
                }}>NEXT</UIText>
            </TouchableOpacity>
        </View>
    </SafeAreaView>
}
export default SelectIngredients