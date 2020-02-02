import React from 'react';
import logo from './logo.svg';
import './App.css';
import Home from './components/Home';
import Routes from './components/route/Routes';
import TransportList from './components/transport/TransportList';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <Home/>
        <Routes/>
        <TransportList/>
        {/* Логика переключения компонентов */}
        </header>
    </div>
  );
}

export default App;
