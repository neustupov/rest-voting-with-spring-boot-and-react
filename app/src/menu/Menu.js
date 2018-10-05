import React, { Component } from 'react';
import { Card } from 'antd';

class Menu extends Component{

    constructor(props){
        super(props);

    }

    render(){
        <Card
            title="Card title"
            extra={<a href="#">More</a>}
            style={{ width: 300 }}
        >
            <p>Card content</p>
            <p>Card content</p>
            <p>Card content</p>
        </Card>
    }
}

export default Menu;