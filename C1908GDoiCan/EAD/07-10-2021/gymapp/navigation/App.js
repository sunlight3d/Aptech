
import * as React from 'react'
import { NavigationContainer } from '@react-navigation/native'
import { createNativeStackNavigator } from '@react-navigation/native-stack'
import {
    Login, 
    Welcome, 
    SelectGender,
    SelectGoal,
    InputAge,
    InputName,
    InputHeight,
    SelectBodyType,
} from '../screens/'

const Stack = createNativeStackNavigator();

const App = (props) => <NavigationContainer>
    <Stack.Navigator initialRouteName="Welcome" screenOptions={{headerShown: false}}>
        <Stack.Screen name="Welcome" component={Welcome} />
        <Stack.Screen name="Login" component={Login} />
        <Stack.Screen name="SelectGender" component={SelectGender} />
        <Stack.Screen name="SelectGoal" component={SelectGoal} />
        <Stack.Screen name="InputAge" component={InputAge} />
        <Stack.Screen name="InputName" component={InputName} />
        <Stack.Screen name="InputHeight" component={InputHeight} />
        <Stack.Screen name="SelectBodyType" component={SelectBodyType} />
    </Stack.Navigator>
</NavigationContainer>

export default App