// src/App.js
import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import Header from './components/Header';
import Login from './features/auth/Login';
import Register from './components/Register';
import PostList from './features/posts/PostList';
import PostForm from './features/posts/PostForm';
import PostDetail from './features/posts/PostDetail';

const App = () => (
  <Router>
    <Header />
    <main>
      <Switch>
        <Route path="/" exact component={() => <h1>Home</h1>} />
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/posts" exact component={PostList} />
        <Route path="/posts/new" component={PostForm} />
        <Route path="/posts/:id" exact component={PostDetail} />
        <Route path="/posts/:id/edit" component={PostForm} />
      </Switch>
    </main>
  </Router>
);

export default App;
