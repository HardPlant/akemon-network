import React, { Component } from 'react';
import LogoHeader from './LogoHeader';
import Navbar from './Navbar';
import MainPanel from '../MainPanel';
import QuickSidebar from '../QuickSidebar';

class MainHeader extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="main-header">
                <LogoHeader/>
                <Navbar/>
                <MainPanel/>
                <QuickSidebar/>
            </div>
        );
    }
}

export default MainHeader;