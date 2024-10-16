
import * as React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import {
    Plan,
    Training,
    Food,
    Challenges,
    Profile
} from '../screens/tabs'

import {
    Login, 
    Welcome, 
    SelectGender,
    SelectGoal,
    InputAge,
    InputName,
    InputHeight,
    SelectBodyType,
    SelectIngredients,
    SelectActivityLevel,
    Register,    
} from '../screens/'
import {Image} from 'react-native'
import {icons, colors} from '../constants'
const Stack = createNativeStackNavigator()
const Tab = createBottomTabNavigator()
const MyTab = (props) => <Tab.Navigator screenOptions={({ route }) => ({
        tabBarIcon: ({ focused, color, size }) => {
        let iconObject
        if (route.name === 'Plan') {
            iconObject = icons.iconPlan
        } else if (route.name === 'Training') {
            iconObject = icons.iconTraining
        } else if (route.name === 'Food') {
            iconObject = icons.iconFood
        } else if (route.name === 'Challenges') {
            iconObject = icons.iconChallenges
        } else if (route.name === 'Profile') {
            iconObject = icons.iconProfile
        }
        return <Image
            source={iconObject}
            style={{ 
                width: 20, 
                height:20, 
                marginTop: 15,
                tintColor: focused ? colors.primary : colors.inactive, 
                marginBottom: 10                                
            }}
        />
        // You can return any component that you like here!
        return <Ionicons name={iconName} size={size} color={color} />;
        },
        tabBarActiveTintColor: colors.primary,
        tabBarInactiveTintColor: colors.inactive,
        headerShown: false
    })}>
    <Tab.Screen name="Plan" component={Plan} />
    <Tab.Screen name="Training" component={Training} />
    <Tab.Screen name="Food" component={Food} />
    <Tab.Screen name="Challenges" component={Challenges} />
    <Tab.Screen name="Profile" component={Profile} />        
    </Tab.Navigator>

const App = (props) => <NavigationContainer>
    <Stack.Navigator initialRouteName="Welcome" screenOptions={{headerShown: false}}>
        <Stack.Screen name="Welcome" component={Welcome} />
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="Register" component={Register} />
        <Stack.Screen name="SelectGender" component={SelectGender} />
        <Stack.Screen name="SelectGoal" component={SelectGoal} />        
        <Stack.Screen name="InputAge" component={InputAge} />
        <Stack.Screen name="InputName" component={InputName} />
        <Stack.Screen name="InputHeight" component={InputHeight} />
        <Stack.Screen name="SelectBodyType" component={SelectBodyType} />
        <Stack.Screen name="SelectIngredients" component={SelectIngredients} />
        <Stack.Screen name="SelectActivityLevel" component={SelectActivityLevel} />
        <Stack.Screen name="MyTab" component={MyTab} />
    </Stack.Navigator>
          
</NavigationContainer>

export default App