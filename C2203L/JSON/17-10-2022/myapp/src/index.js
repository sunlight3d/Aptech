import React from 'react';
import ReactDOM from 'react-dom/client';
import TemperatureMonitor from './components/TemperatureMonitor';
import Welcome from './components/Welcome';
import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <Welcome name={"Hoang"} x = {1} y = {2}/> */}
    <TemperatureMonitor />
  </React.StrictMode>
);

reportWebVitals();
