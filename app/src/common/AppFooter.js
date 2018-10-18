import React, {Component} from 'react';
import {Layout} from 'antd';
import './AppHeaderAndFooter.css';
import {Link} from "react-router-dom";

const Footer = Layout.Footer;

class AppFooter extends Component {

    render() {
        return (
            <Footer className="app-footer">
                <div className="container">
                    <Link to="/">Maven/ Spring Boot / Security/ JPA(Hibernate)/ Jackson/ React application</Link>
                </div>
            </Footer>
        );
    }
}

export default AppFooter;