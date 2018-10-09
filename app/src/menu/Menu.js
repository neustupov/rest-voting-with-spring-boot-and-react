import React, {Component} from 'react';
import {Card} from 'antd';

class Menu extends Component {

    constructor(props) {
        super(props);
    }

    render() {
        return (
            <Card
                title={this.props.menu.nameOfRestaurant}
                extra={<a href="#">More</a>}
                style={{width: 300}}
            >
                <p>{this.props.menu.meals(1).name}</p>
                <p>Card content</p>
                <p>Card content</p>
            </Card>)
    }
}

export default Menu;