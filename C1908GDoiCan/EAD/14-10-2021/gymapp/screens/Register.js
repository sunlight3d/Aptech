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
import { validations } from '../utilities'

const Register = (props) => {
    const {navigation} = props
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    const [retypePassword, setRetypePassword] = useState('');
    const [passwordVisible, setPasswordVisible] = useState(false);
    //error message
    const [errorEmail, setErrorEmail] = useState('')
    const [errorPassword, setErrorPassword] = useState('')
    const {isValidEmail} = validations

    const validateOK = () => errorEmail == '' && errorPassword == ''
                                && email.length > 0 && password.length > 0 && retypePassword.length > 0
    return <SafeAreaView style={{
            backgroundColor: 'white',
            flex: 1,
            flexDirection: 'column'
        }}>
        <UIHeader onPressBack = {() => {
            navigation.goBack()
        }} title = {'Create account'}/>
        <TextInput
            style={{
                height: 40,
                margin: 12,
                borderBottomWidth: 1,
                padding: 10,                            
                borderBottomColor: colors.placeholderText
            }}            
            autoCapitalize = {"none"}
            value={email} 
            placeholder="Email"
            keyboardType="email-address"
            onChangeText={(text)=>{
                setEmail(text.trim())
                setErrorEmail(isValidEmail(text) ? '' : 'Invalid email address')
            }}
      />
      <UIText style={{
            color: 'red',
            paddingHorizontal: 15,
            height: errorEmail == '' ? 0 : 20
        }}>{errorEmail}</UIText>      
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
                if(text.length == 0) {
                    setErrorPassword('Password must not be blank')
                } else if(text.length > 0 && retypePassword.length > 0) {
                    if(text != retypePassword) {
                        setErrorPassword('Password and retype password are not the same')
                    } else {
                        setErrorPassword('')
                    }
                }
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
            color: 'red',
            paddingHorizontal: 15,
            height: errorPassword == '' ? 0 : 20
        }}>{errorPassword}</UIText>      
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
                debugger                
                if(text.length == 0) {
                    setErrorPassword('Password must not be blank')
                } else if(password.length > 0 && text.length > 0) {
                    if(password != text) {
                        setErrorPassword('Password and retype password are not the same')
                    } else {
                        setErrorPassword('')
                    }
                }
                setRetypePassword(text)
            }}
            value={retypePassword} 
            secureTextEntry = {!passwordVisible}
            placeholder="Re-enter your password"        
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
            Already have an account?
       </UIText>          
      <TouchableOpacity onPress={() => {
          navigation.navigate('Login')
      }}>
        <UIText style={{
                fontSize: fonts.h4,
                color: colors.inactive,
                textAlign: 'center',
                padding: 10,
                textDecorationLine: 'underline',
            }}>
                Login
            </UIText>
      </TouchableOpacity>      
      <TouchableOpacity style={{
                backgroundColor: validateOK() == true ? colors.primary : colors.inactive,            
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
                    if(validateOK() == true) {
                        navigation.navigate('SelectBodyType')
                    }                    
                }}
            >
                <UIText style={{
                    color: 'white',
                }}>NEXT</UIText>
            </TouchableOpacity>
    </SafeAreaView>
}
export default Register