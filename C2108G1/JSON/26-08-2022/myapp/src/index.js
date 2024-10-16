import React from 'react';
import ReactDOM from 'react-dom/client';
import Part1 from './Part1'
import Part2 from './Part2'
import Part3 from './Part3'
import Part3CallApi from './Part3CallApi'
//yarn add react-bootstrap bootstrap
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    {/* <Part1 /> */}
    {/* <Part2 /> */}
    {/* <Part3 /> */}
    <Part3CallApi />
  </React.StrictMode>
);