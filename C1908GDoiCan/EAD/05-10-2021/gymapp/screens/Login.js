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

const Login = (props) => {
    const {navigation} = props
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [passwordVisible, setPasswordVisible] = useState(false);

    return <SafeAreaView style={{
            backgroundColor: 'white',
            flex: 1,
            flexDirection: 'column'
        }}>
        <UIHeader onPressBack = {() => {
            navigation.goBack()
        }} title = {'Login'}/>
        <TextInput
            style={{
                height: 40,
                margin: 12,
                borderBottomWidth: 1,
                padding: 10,            
                borderBottomColor: colors.placeholderText
            }}            
            value={email} 
            placeholder="Email"
            keyboardType="email-address"
            onChangeText={(text)=>{
                setEmail(text)
            }}
      />
      
      <View style={{          

      }}>
        <TextInput
            style={{
                height: 40,
                margin: 12,
                borderBottomWidth: 1,
                padding: 10,            
                borderBottomColor: colors.placeholderText
            }}
            onChangeText={(text)=>{
                setPassword(text)
            }}
            value={password} 
            secureTextEntry = {!passwordVisible}
            placeholder="Password"        
        />
        <TouchableOpacity 
            style={{
                position: 'absolute',                
                bottom: 0,
                right: 0,
                padding: 20,                
            }}
            onPress={()=>{
                setPasswordVisible(!passwordVisible)
            }}>
            <Image
                source={icons.eye}
                style={{ 
                    width: 22, 
                    height: 22, 
                    tintColor: colors.placeholderText 
                }}
            />
        </TouchableOpacity>        
      </View>  
      <UIText style={{                    
            fontSize: fonts.h4,
            color: colors.inactive,
            paddingHorizontal: 20,
            textAlign: 'center',            
            marginTop: 20,
        }}>
            Don't have an account?
       </UIText>          
      <TouchableOpacity>
        <UIText style={{
                fontSize: fonts.h4,
                color: colors.inactive,
                textAlign: 'center',
                padding: 10,
                textDecorationLine: 'underline',
            }}>
                Create account
            </UIText>
      </TouchableOpacity>
      <TouchableOpacity>
        <UIText style={{
                fontSize: fonts.h4,
                color: colors.inactive,
                textAlign: 'center', 
                paddingBottom: 10,                
                textDecorationLine: 'underline',
            }}>
                Forgot Password ?
            </UIText>
      </TouchableOpacity>
    </SafeAreaView>
}
export default Login