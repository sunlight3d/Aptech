import React from 'react';
import ReactDOM from 'react-dom'
import './index.css';
import App from './App'
import Home from './views/Home/Home'
import reportWebVitals from './reportWebVitals';
import { Provider } from 'react-redux'
import { createStore, applyMiddleware } from 'redux'
import createSagaMiddleware from 'redux-saga'
import rootReducer from './redux/reducers/index'

import rootSaga from './redux/sagas/product'
import { eventChannel, END } from 'redux-saga'
const sagaMiddleware = createSagaMiddleware()

console.log(rootSaga)
debugger
const store = createStore(
  rootReducer,
  applyMiddleware(sagaMiddleware)
)
sagaMiddleware.run(rootSaga)
/*
store.close = () => () => {
  console.log('end saga')
  store.dispatch(END)
}
*/
/**
 npm install redux-saga
 npm install redux
 */
ReactDOM.render(
  <React.StrictMode>
    <Provider store={store}>
      <Home name = {"Hoang"} age = {18}/>    
      </Provider>
    {/* <App /> */}
    
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
