import React from 'react';
import './App.css';
import Home from './components/Home';
import Routes from './components/route/Routes';
import TransportList from './components/transport/TransportList';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';
import { BrowserRouter as Router, Route } from "react-router-dom";


function App() {

  return (
    <Router>
      <div className="App">
        <div className="container" >
          <Route path="/" exact component={Home}/>
          <Route strict path="/routes" exact component={Routes} />
          <Route strict path="/transports" exact component={TransportList} />
          <Route path="/routes/add" exact component={InputRoute} />
          <Route path="/transports/add" exact component={InputTransport} />
        </div>
      </div>
    </Router>
   
  );
}

export default App;