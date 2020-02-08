import React from 'react';
import './App.css';
import Home from './components/Home';
import Login from './components/Login';
import Routes from './components/route/Routes';
import MyRoutes from './components/route/MyRoutes';
import TransportList from './components/transport/TransportList';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';
import { Router, Route, Link } from "react-router-dom";
import history from './history';

function App() {

  return (
    <Router history={history}>
      <div className="App">
        <header className="App-header">
          <div className="d-flex justify-content-around">
            <Link type="button" to='/routes' className="btn btn-primary m-3">Routes</Link>
            <Link type="button" to='/transports' className="btn btn-primary m-3">Transports</Link>
            <Link type="button" to='/users/login' className="btn btn-primary m-3">My Routes</Link>
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