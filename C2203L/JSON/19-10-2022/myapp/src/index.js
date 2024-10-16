import React from 'react';
import ReactDOM from 'react-dom/client';
import Welcome from './components/Welcome';
import {TemperatureMonitor, CategoryList} from './components';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <Welcome name={"Hoang"} x = {1} y = {2}/> */}
    <CategoryList />
  </React.StrictMode>
);

reportWebVitals();
