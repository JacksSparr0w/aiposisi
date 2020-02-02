import React from 'react';
import './App.css';
import Home from './components/Home';
import Routes from './components/route/Routes';
import TransportList from './components/transport/TransportList';
import InputTransport from './components/transport/InputTransport';
import InputRoute from './components/route/InputRoute';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Home/>
        <Routes/>
        <TransportList/>
        <InputRoute/>
        <InputTransport/>
        {/* Логика переключения компонентов */}
        </header>
    </div>
  );
}

export default App;
