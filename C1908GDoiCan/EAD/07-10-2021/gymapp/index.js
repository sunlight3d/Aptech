/**
find ~/.gradle -type f -name "*.lock" -delete
yarn add @react-navigation/native
yarn add @react-navigation/native-stack
yarn add react-native-safe-area-context
yarn add react-native-screens
yarn add @react-native-async-storage/async-storage
 */
import {AppRegistry} from 'react-native'
import App from './navigation/App';
//import { InputAge } from './screens'
import { InputHeight, SelectBodyType } from './screens'
import {name as appName} from './app.json'

AppRegistry.registerComponent(appName, () => SelectBodyType)
