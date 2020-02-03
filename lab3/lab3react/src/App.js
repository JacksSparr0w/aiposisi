import React from 'react';
import './App.css';
import Home from './components/Home';
import Login from './components/Login';
import Routes from './components/route/Routes';
import MyRoutes from './components/route/MyRoutes';
import TransportList from './components/transport/TransportList';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';
import { BrowserRouter as Router, Route } from "react-router-dom";


function App() {

  return (
    <Router>
      <div className="App">
        <header className="App-header">
          <div className="d-flex justify-content-around">
            <button type="button" onClick={(e) => { window.location.assign('/routes'); }} className="btn btn-primary m-3">Routes</button>
            <button type="button" onClick={(e) => { window.location.assign('/transports'); }} className="btn btn-primary m-3">Transport</button>
            <button type="button" onClick={(e) => { window.location.assign('/users/login'); }} className="btn btn-primary m-3">My routes</button>
          </div>
          <Route path="/" exact component={Home} />
          <Route strict path="/routes" exact component={Routes} />
          <Route strict path="/transports" exact component={TransportList} />
          <Route path="/routes/add" exact component={InputRoute} />
          <Route strict path="/routes/:id/join" exact component={Login} />
          <Route strict path="/transports/add" exact component={InputTransport} />
          <Route path="/users/login" exact component={Login} />
          <Route path="/users/:login/watchRoutes" exact component={MyRoutes} />
          <Route path="/transports/:id/update" exact component={InputTransport} />
          <Route path="/routes/:id/update" exact component={InputRoute} />
        </header>
      </div>
    </Router>

  );
}

export default App;