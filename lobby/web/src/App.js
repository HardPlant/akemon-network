import React, { Component } from 'react';
import './App.css';
import MainHeader from './components/header/MainHeader';
import Sidebar from './components/Sidebar';
import MainPanel from './components/MainPanel';
import QuickSidebar from './components/QuickSidebar';

class App extends Component {
  render() {
    return (
      <div className="wrapper">
        <MainHeader />
        <Sidebar/>
        <MainPanel/>
        <QuickSidebar/>
      </div>
    );
  }
}

export default App;
