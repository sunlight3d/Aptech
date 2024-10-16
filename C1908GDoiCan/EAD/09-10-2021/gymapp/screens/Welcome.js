import React from "react"
import { 
    View, 
    Text,
    Image,
    StyleSheet,
    Dimensions,
    TouchableOpacity,
    SafeAreaView,
} from "react-native"
import {colors, images, fonts, sizes} from '../constants'
const {windowWidth, windowHeight} = sizes
import FontAwesome from 'react-native-vector-icons/FontAwesome'
import UIText from "../widgets/UIText"

const Welcome = (props) => {
    const imageWidth = 0.8 * windowWidth
    const imageHeight = imageWidth * 417 / 626
    const {navigation} = props
    return <SafeAreaView style={{
        flex: 1,         
        justifyContent: 'space-between',
        alignItems: 'center',
        backgroundColor: 'white',        
    }}>        
        <View style={{
            flexDirection: 'row', 
            justifyContent: 'space-between', 
            alignContent: 'center',             
            paddingHorizontal: 10,
            paddingTop: 10,            
            width: '100%'
         }}>
            <Image 
                source={images.logo}
                style={{
                    resizeMode: 'contain',                
                    height: 50,         
                    width: 50*(796/632),                    
                }}
            />
            <TouchableOpacity             
            onPress={()=>{
                navigation.navigate('SelectGender')
            }}>
                <UIText style={{
                    color: colors.primary, 
                    lineHeight: 50,
                    fontSize: fonts.h3,
                    fontWeight: 'bold'
                }}>
                    SKIP</UIText>
            </TouchableOpacity>
        </View>         
        <Image
            source={images.welcome}
            fadeDuration = {400}
            style={{
                resizeMode: 'contain',                
                width: imageWidth,                                                      
                height: imageHeight,                                
                overflow: "hidden", 
                borderRadius: 300                 
            }}
        />
        <View style={{height: 100, justifyContent: 'center', alignItems: 'center'}}>
            <View style={{
                flexDirection: 'row', 
                alignItems: 'center',
                paddingTop: 20,
                paddingBottom: 10
            }}>
                <UIText style={{
                        fontWeight: 'bold', 
                        paddingRight: 5,                     
                        }}>
                    Welcome to MyApp
                </UIText>
                <FontAwesome name="heart" size={15} color= {colors.red} />   
            </View>
            <UIText style={{                    
                fontSize: fonts.h4,
                color: colors.inactive,
                paddingHorizontal: 50,
                textAlign: 'center',
                marginBottom: 20,                        
            }}>
                Improve your health with gym, meal plans and calorie tracker    
            </UIText>     
        </View>           
        <View style={{height: 100, width: '100%'}}>
            <View style={{            
                width: '100%',                        
                paddingHorizontal: 40,            
            }}>
                <TouchableOpacity style={{            
                    backgroundColor: colors.primary,
                    width: '100%',        
                    justifyContent: 'center',
                    alignItems: 'center',    
                    height: 40,
                    borderRadius: 20
                }}
                onPress={()=>{
                    navigation.navigate('Login')
                }}
                >
                    <UIText style={{
                        color: 'white',                    
                    }}>LOGIN</UIText>
                </TouchableOpacity>                      
            </View>
            <TouchableOpacity 
                onPress={()=>{
                    alert('create account')
                }}
            >
                    <UIText style={{
                        color: colors.primary,                    
                        textAlign: 'center',
                        padding: 10
                    }}>CREATE ACCOUNT</UIText>           
            </TouchableOpacity>
        </View>
        <View style={{height: 80}}>
        <UIText style={{                    
            fontSize: fonts.h5,
            color: colors.inactive,
            paddingHorizontal: 20,
            textAlign: 'center',
            marginBottom: 5
        }}>
            By continuing you accept our
        </UIText>                    
        <View style={{
            flexDirection:'row', 
            flexWrap:'wrap',            
        }}>
                <UIText style={{                    
                    fontSize: fonts.h5,
                    color: colors.inactive,                
                    textAlign: 'center',
                    marginBottom: 20,
                    textDecorationLine: 'underline',                    
                    paddingRight: 5,
                }}> 
                    Privacy Policy
                </UIText>    
                <UIText style={{                    
                    fontSize: fonts.h5,
                    color: colors.inactive,                
                    textAlign: 'center',
                    marginBottom: 20,                
                    paddingRight: 5,
                }}> 
                    and
                </UIText>    
                <UIText style={{                    
                    fontSize: fonts.h5,
                    color: colors.inactive,                
                    textAlign: 'center',
                    marginBottom: 20,
                    textDecorationLine: 'underline',
                }}> 
                    Terms of Use
                </UIText>                        
        </View>
        </View>
        
    </SafeAreaView>
}
const styles = StyleSheet.create({
    container: {
        flex: 1,         
        justifyContent: 'flex-end',
        alignItems: 'center',
        backgroundColor: 'white',
        
    },    
})
export default Welcome