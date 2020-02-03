import React from 'react';
import './App.css';
import Home from './components/Home';
import LoginForJoin from './components/LoginForJoin';
import Login from './components/Login';
import Routes from './components/route/Routes';
import MyRoutes from './components/route/MyRoutes';
import TransportList from './components/transport/TransportList';
import UpdateTransport from './components/transport/UpdateTransport';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';
import UpdateRoute from './components/route/UpdateRoute';
import { BrowserRouter as Router, Route } from "react-router-dom";


function App() {

  return (
    <Router>
      <div className="App">
      <header className="App-header">
          <Route path="/" exact component={Home}/>
          <Route strict path="/routes" exact component={Routes} />
          <Route strict path="/transports" exact component={TransportList} />
          <Route path="/routes/add" exact component={InputRoute} />
          <Route strict path="/routes/:id/join" exact component={LoginForJoin} />
          <Route strict path="/transports/add" exact component={InputTransport} />
          <Route path="/users/login" exact component={Login} />
          <Route path="/users/:login/watchRoutes" exact component={MyRoutes} />
          <Route path="/transports/:id/update" exact component={UpdateTransport} />
          <Route path="/routes/:id/update" exact component={InputRoute} />
        </header>
      </div>
    </Router>
   
  );
}

export default App;