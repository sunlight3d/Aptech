import React, { useState, useEffect } from 'react'
import { 
    View, 
    TextInput,
    Image,
    StyleSheet,
    Dimensions,
    TouchableOpacity,
    SafeAreaView,
    ScrollView,
} from "react-native"
import {colors, images, fonts, sizes, icons} from '../../constants'
const {windowWidth, windowHeight} = sizes
import UIText from "../../widgets/UIText"

const Profile = (props) => {    
    //const {navigation} = props
    return <SafeAreaView style={{
            flex: 1, 
            justifyContent: 'center',
            alignItems: 'center'
        }}>        
        <ScrollView style={{flex: 1}}>
            <Image
                source={icons.iconProfile}
                style={{
                    width: 100,
                    height: 100,
                    tintColor: colors.primary,                    
                    marginBottom: 10
                }}
            />
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>arerereaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>sdsdsfdfdf</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
            <UIText>aaadde</UIText>
        </ScrollView>
        
                
    </SafeAreaView>
}
export default Profile