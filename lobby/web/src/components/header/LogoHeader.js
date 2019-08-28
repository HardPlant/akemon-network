import React, { Component } from 'react';

class LogoHeader extends Component {
    constructor(props) {
        super(props);
        this.state = {}
    }
    render() {
        return (
            <div className="logo-header" data-background-color="blue">

                <a href="index.html" className="logo">
                    <img src="https://via.placeholder.com/100x35" alt="navbar brand" className="navbar-brand" />
                </a>
                <button className="navbar-toggler sidenav-toggler ml-auto" type="button" data-toggle="collapse" data-target="collapse" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon">
                        <i className="icon-menu"></i>
                    </span>
                </button>
                <button className="topbar-toggler more"><i className="icon-options-vertical"></i></button>
                <div className="nav-toggle">
                    <button className="btn btn-toggle toggle-sidebar">
                        <i className="icon-menu"></i>
                    </button>
                </div>
            </div>
        );
    }
}

export default LogoHeader;