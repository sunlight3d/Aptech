import React from 'react';
import ReactDOM from 'react-dom';
// import './index.css';
// import App from './App';
import QuizScreen from './screens/QuizScreen'
import reportWebVitals from './reportWebVitals'
import {questions} from './data/fakeData'
//let questions = require('./data/fakeData')
ReactDOM.render(
  <React.StrictMode>
    <QuizScreen x = {1} questions={questions}/>
  </React.StrictMode>,
  document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
