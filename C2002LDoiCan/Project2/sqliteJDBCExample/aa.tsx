import React, { useState, useEffect } from 'react';
import {
    View,
    StyleSheet,
    Image,
    TextInput,
    TouchableOpacity,
} from 'react-native';
import { size, get } from 'lodash';
import Body from '../Element/Body';
import Colors from '../../Style/Colors';
import UIText from '../../Component/UIText';
import { useNavigation, useRoute } from '@react-navigation/native';
import { RouteNames } from '../../Router/route-names';
import Toast from 'react-native-toast-message';
import { loginAction, resetAction, getUserData } from "../../Actions/userPageAction";
import { connect } from "react-redux";
import FontAwesome from "react-native-vector-icons/FontAwesome";
import AntDesign from "react-native-vector-icons/AntDesign";

const LoginPhone = (props: any) => {
    const navigation = useNavigation();
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [securePassword, setSecurePassword] = useState(true);
    const route = useRoute();
    const param = route.params;
    const [userData, setUserData] = useState('');
    if (props.userPage.isFetching === false && props.userPage.message !== "") {
        Toast.show({
            type: get(props, 'userPage.error', true) === true ? 'error' : 'success',
            position: 'top',
            text1: 'Thông báo',
            text2: props.userPage.message,
            visibilityTime: 1000,
            autoHide: true,
            topOffset: 50,
            bottomOffset: 40,
            onHide: () => {
                if (get(props, 'userPage.message', '') === "Đăng nhập thành công") {
                    props.getUserData();
                    navigation.navigate("MainDrawer")
                }
            },
            onShow: () => {
                props.resetAction();
            },
        });
    }
    
    if (Object.keys(props.userPage.userInfo).length > 0) {
        props.navigation.navigate('MainDrawer');
    }

    useEffect(() => {
        checkUserData();
    }, [])

    const checkUserData = () => {
        props.getUserData();
    }
    
    return (
        <View style={styles.container}>
            {/* <Spinner 
                visible={get(props, 'userPage.isFetching', '')}
            /> */}
            <Body
                style={{ backgroundColor: '#FEF9F2', }}
                contentContainerStyle={{ flexGrow: 1, justifyContent: 'center' }}>
                <View style={{ alignItems: 'center' }}>
                    <Image source={require('../../assets/fashion-01.png')} 
                        style={{width: 218, height: 240, resizeMode: 'stretch'}}
                    />
                </View>
                <View style={{                     
                    marginTop: 20, backgroundColor: '#F9EAEA',                     
                    borderTopLeftRadius: 20, borderTopRightRadius: 20,                    
                    }}>
                    <UIText
                        style={{ paddingTop: 20, textAlign: 'center', fontSize: 17 }}>ĐĂNG NHẬP
                        </UIText>
                    <View style={styles.textInput}>
                        <Image source={require('../../assets/acc3.png')}
                            style={{ width: 18, height: 18, resizeMode: 'stretch' }}
                        />
                        <TextInput
                            style={{
                                flex: 1,
                                padding: 10,
                            }}
                            placeholderTextColor="#6A6A6A"
                            placeholder="Số điện thoại/email"
                            onChangeText={username => setUsername(username)}
                            defaultValue={username}
                            autoFocus={true}
                        />
                    </View>
                    <View style={styles.textInput}>
                        <Image source={require('../../assets/lock.png')}
                            style={{ width: 14, height: 18, resizeMode: 'stretch' }}
                        />
                        <TextInput
                            style={{
                                flex: 1,
                                padding: 10,
                            }}
                            placeholderTextColor="#6A6A6A"
                            placeholder="Mật khẩu"
                            secureTextEntry={securePassword}                            
                            onChangeText={password => setPassword(password)}
                            defaultValue={password}
                        />
                        <TouchableOpacity style = {{ padding: 17,paddingRight: 2}} onPress={()=>{
                            setSecurePassword(!securePassword)
                        }}>
                            <Image source={require('../../assets/eye.png')}
                                style={{ width: 22, height: 12, resizeMode: 'stretch' }}
                            />
                        </TouchableOpacity>
                    </View>                    
                    <View style={{ marginHorizontal: 25, alignItems: 'flex-end' }}>
                        <TouchableOpacity
                            onPress={() => {
                                navigation.navigate(RouteNames.FORGOTPASS);
                            }}
                            activeOpacity={0.8}
                        >
                            <UIText style={styles.textBtnRegister}>Quên mật khẩu?</UIText>
                        </TouchableOpacity>
                    </View>
                    <View style={{ marginTop: 20 }}>
                        <TouchableOpacity
                            style={{flexDirection:'row', alignItems:'center', alignSelf:'flex-end', paddingEnd:25}}
                            activeOpacity={0.8}                            
                            onPress={() => {
                                if (username === '' || password === '') {
                                    Toast.show({
                                        type: 'error',
                                        position: 'top',
                                        text1: 'Thông báo',
                                        text2: 'Vui lòng điền đầy đủ email và password',
                                        visibilityTime: 1000,
                                        autoHide: true,
                                        topOffset: 50,
                                        bottomOffset: 40,
                                        onShow: () => {
                                        },
                                        onHide: () => {
                                        },
                                    });
                                } else {
                                    props.loginAction(username, password);
                                }
                            }}>
                            <UIText style={{alignItems:'center', paddingRight: 10}}>Đăng nhập</UIText>
                            <Image source={require('../../assets/arrow.png')}
                                style={{ width: 55 ,height: 32, resizeMode: 'stretch' }}
                            />
                        </TouchableOpacity>
                        <View style={{height: 30}}>

                        </View>
                        <View style={{flex:1,alignItems:'center',justifyContent:'center',alignSelf:'stretch'}}>
                            <UIText style={{ marginBottom: 10, textAlign: 'center'}}>Hoặc đăng nhập</UIText>
                            <View
                            style={{
                                flexDirection: 'row',
                                alignItems: 'center',
                                justifyContent: 'center',
                            }}>
                                <TouchableOpacity>
                                    <Image source={require('../../assets/facebook.png')}
                                        style={{ width: 50 ,height: 50, resizeMode: 'stretch' }}
                                    />  
                                </TouchableOpacity>
                                <TouchableOpacity>
                                    <Image source={require('../../assets/gmail.png')}
                                        style={{ width: 50 ,height: 50, resizeMode: 'stretch' }}
                                    />  
                                </TouchableOpacity>
                            </View>                        
                            <View
                                style={{                                
                                    flexDirection: 'row',
                                    alignItems: 'center',
                                    justifyContent: 'center',
                                }}>
                                <UIText style={{ marginRight: 10, fontSize: 15, color: 'black' }}>Chưa có tài khoản?</UIText>
                                <TouchableOpacity
                                    activeOpacity={0.8}
                                    onPress={() =>
                                        navigation.navigate('AuthenScreen')
                                    }
                                >
                                    <UIText style={{ fontSize: 15, textDecorationLine: 'underline', color: Colors.mainColor }}>Đăng ký</UIText>
                                </TouchableOpacity>
                            
                            </View>
                        </View>
                        <View style={{                     
                            backgroundColor: '#F9EAEA', 
                            height:200             
                            }}>
                        </View> 
                    </View>                    
                </View>
                
            </Body>
        </View>
    );
};

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#FEF9F2',
        borderRadius: 0,
        justifyContent: "space-between",
        paddingTop: 50
    },
    textInput: {
        flex: 1,
        flexDirection: 'row',
        justifyContent: 'center',
        alignItems: 'center',                        
        marginHorizontal: 25,
        marginTop: 20,
        paddingHorizontal: 15,
        height: 50,
        borderRadius: 25,
        backgroundColor: 'white',                        
    },
    btnLogin: {
        height: 35,
        width: 100,
        backgroundColor: Colors.mainColor,
        justifyContent: 'center',
        alignItems: 'center',
        borderRadius: 15,
        marginBottom: 20
    },
    btnRegister: {
        fontSize: 14,
        paddingVertical: 15,
        marginHorizontal: 30,
        justifyContent: 'center',
        alignItems: 'center',
        marginTop: 0,
        borderRadius: 10,
    },
    textBtn: {
        fontSize: 13,
        color: 'white',
        textTransform: 'uppercase',
        // fontWeight: 'bold',
    },
    textBtnRegister: {
        // fontWeight: 'bold',
        color: '#373737',
        fontSize: 13,
        marginTop: 20
    },
    btnFB: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        paddingHorizontal: 17
    }
});

LoginPhone.defaultProps = {
    userPage: {
        data: {},
        isFetching: false
    },
};
const mapStateToProps = (state: any) => {
    return {
        'userPage': state.userPage
    }
}

const mapDispatchToProps = (dispatch: any) => {
    return {
        loginAction: (username: string, password: string) => {
            dispatch(loginAction(username, password))
        },
        resetAction: () => {
            dispatch(resetAction())
        },
        getUserData: () => {
            dispatch(getUserData())
        }
    }
};

export default connect(mapStateToProps, mapDispatchToProps)(LoginPhone);
